
package com.equipo7.proyecto1.ticketwizzard.gestores;

import com.equipo7.proyecto1.ticketwizzard.dao.EventosDAO;
import com.equipo7.proyecto1.ticketwizzard.dtos.CiudadDTO;
import com.equipo7.proyecto1.ticketwizzard.dtos.EventoDTO;
import com.equipo7.proyecto1.ticketwizzard.excepciones.DAOException;
import com.equipo7.proyecto1.ticketwizzard.excepciones.GestorException;
import com.equipo7.proyecto1.ticketwizzard.interfaces.dao.IEventosDAO;
import com.equipo7.proyecto1.ticketwizzard.interfaces.gestores.IGestorEventos;
import com.equipo7.proyecto1.ticketwizzard.objetos.Ciudad;
import com.equipo7.proyecto1.ticketwizzard.objetos.Evento;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Equipo 7
 */
public class GestorEventos implements IGestorEventos {
    private static GestorEventos instance;
    
    private IEventosDAO eventosDAO;
    
    private GestorEventos() {
        this.eventosDAO = EventosDAO.getInstance();
    }
    
    public static IGestorEventos getInstance() {
        if (instance == null) {
            instance = new GestorEventos();
        }
        
        return instance;
    }
    
    /**
     * Convierte el evento entidad dado en objeto DTO
     * @param evento Evento entidad
     * @return 
     */
    private EventoDTO convertirEntidad(Evento evento) {
        EventoDTO eventoDTO = new EventoDTO();
                
        eventoDTO.setId(evento.getId());
        eventoDTO.setNombre(evento.getNombre());
        eventoDTO.setDescripcion(evento.getDescripcion());
        eventoDTO.setFechaHora(evento.getFechaHora());
        eventoDTO.setTerminado(evento.getTerminado());
        eventoDTO.setVenue(evento.getVenue());
        
        evento.setId(evento.getId());
        evento.setNombre(evento.getNombre());
        evento.setDescripcion(evento.getDescripcion());
        evento.setFechaHora(evento.getFechaHora());
        evento.setTerminado(evento.getTerminado());
        evento.setVenue(evento.getVenue());
        
        CiudadDTO ciudad = new CiudadDTO(
                evento.getCiudad().getNombre(),
                evento.getCiudad().getEstado()
        );
        
        eventoDTO.setCiudad(ciudad);
        
        return eventoDTO;
    }
    
    /**
     * Convierte el evento DTO dado a objeto entidad
     * @param evento
     * @return 
     */
    private Evento convertirDTO(EventoDTO evento) {
        Evento eventoEnt = new Evento();
        
        eventoEnt.setId(evento.getId());
        eventoEnt.setNombre(evento.getNombre());
        eventoEnt.setDescripcion(evento.getDescripcion());
        eventoEnt.setFechaHora(evento.getFechaHora());
        eventoEnt.setTerminado(evento.getTerminado());
        eventoEnt.setVenue(evento.getVenue());
        
        Ciudad ciudad = new Ciudad(
                evento.getCiudad().getNombre(),
                evento.getCiudad().getEstado()
        );
        
        eventoEnt.setCiudad(ciudad);
        
        return eventoEnt;
    }
    
    @Override
    public List<EventoDTO> obtenerEventosTodos() throws GestorException {
        try {
            List<Evento> listaEventos = this.eventosDAO.obtenerEventosTodos();
            
            if (listaEventos == null || listaEventos.isEmpty()) {
                throw new DAOException("No se encontraron eventos registrados");
            }
            
            List<EventoDTO> eventos = new ArrayList<>();
            
            for (Evento e: listaEventos) {
                eventos.add(this.convertirEntidad(e));
            }
            
            return eventos;
        } catch (DAOException ex) {
            throw new GestorException(ex.getMessage());
        }
    }

    @Override
    public List<EventoDTO> obtenerEventosPorCiudad(String nombreCiudad) throws GestorException {
        try {
            
            if (nombreCiudad == null || nombreCiudad.isBlank()||nombreCiudad.isEmpty()) {
                throw new DAOException("Porfavor, ingrese el nombre de la ciudad a buscar");
            }
            
            List<Evento> listaEventos = this.eventosDAO.obtenerEventosPorCiudad(nombreCiudad);
            
            if (listaEventos == null || listaEventos.isEmpty()) {
                throw new DAOException("No se encontraron eventos registrados");
            }
            
            List<EventoDTO> eventos = new ArrayList<>();
            
            for (Evento e: listaEventos) {
                eventos.add(this.convertirEntidad(e));
            }
            
            return eventos;
        } catch (DAOException ex) {
            throw new GestorException(ex.getMessage());
        }
    }

    @Override
    public List<EventoDTO> obtenerEventosPorCiudad(Integer idCiudad) throws GestorException {
        try {
            
            if (idCiudad == null) {
                throw new DAOException("No se pudo encontrar la ciudad indicada (no ID)");
            }
            
            List<Evento> listaEventos = this.eventosDAO.obtenerEventosPorCiudad(idCiudad);
            
            if (listaEventos == null || listaEventos.isEmpty()) {
                throw new DAOException("No se encontraron eventos en la ciudad indicada");
            }
            
            List<EventoDTO> eventos = new ArrayList<>();
            
            for (Evento e: listaEventos) {
                eventos.add(this.convertirEntidad(e));
            }
            
            return eventos;
        } catch (DAOException ex) {
            throw new GestorException(ex.getMessage());
        }
    }
    
    @Override
    public EventoDTO obtenerEvento(Integer id) throws GestorException {
        try {
            Evento evento = this.eventosDAO.obtenerEvento(id);
            
            if (evento == null) {
                throw new DAOException("No se encontro el evento");
            }
            
            return this.convertirEntidad(evento);
        } catch (DAOException ex) {
            throw new GestorException(ex.getMessage());
        }
    }

    @Override
    public void agregarEvento(EventoDTO evento) throws GestorException {
        try {
            if (evento == null) {
                throw new DAOException("La informacion del evento es erronea o esta incompleta, porfavor ingrese los datos correspondientes");
            }
            
            this.eventosDAO.agregarEvento(this.convertirDTO(evento));
        } catch (DAOException ex) {
            throw new GestorException(ex.getMessage());
        }
    }

    @Override
    public void actualizarEvento(EventoDTO evento) throws GestorException {
        try {
            
            if (evento == null) {
                throw new DAOException("La informacion del evento es erronea o esta incompleta, porfavor ingrese los datos correspondientes");
            }
            
            this.eventosDAO.actualizarEvento(this.convertirDTO(evento));
        } catch (DAOException ex) {
             throw new GestorException(ex.getMessage());
        }
    }

    @Override
    public void eliminarEvento(Integer id) throws GestorException {
        try {
            
            if (id == null) {
                throw new DAOException("El ID del evento dado no es valido, porfavor ingrese uno con formato correcto");
            }
            
            this.eventosDAO.eliminarEvento(id);
        } catch (DAOException ex) {
            throw new GestorException(ex.getMessage());
        }
    }
}
