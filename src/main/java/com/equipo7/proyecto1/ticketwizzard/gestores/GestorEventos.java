/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.equipo7.proyecto1.ticketwizzard.gestores;

import com.equipo7.proyecto1.ticketwizzard.dtos.EventoDTO;
import com.equipo7.proyecto1.ticketwizzard.excepciones.GestorException;
import com.equipo7.proyecto1.ticketwizzard.interfaces.dao.IEventosDAO;
import com.equipo7.proyecto1.ticketwizzard.interfaces.gestores.IGestorEventos;
import com.equipo7.proyecto1.ticketwizzard.objetos.Evento;
import java.util.List;

/**
 *
 * @author Equipo 7
 */
public class GestorEventos implements IGestorEventos {
    private IEventosDAO eventosDAO;
    
    public GestorEventos() {
        
    }
    
    /**
     * Convierte el evento entidad dado en objeto DTO
     * @param evento Evento entidad
     * @return 
     */
    private EventoDTO convertirEntidad(Evento evento) {
        return null;
    }
    
    /**
     * Convierte el evento DTO dado a objeto entidad
     * @param evento
     * @return 
     */
    private EventoDTO convertirDTO(EventoDTO boleto) {
        return null;
    }
    
    @Override
    public List<EventoDTO> obtenerEventosTodos() throws GestorException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<EventoDTO> obtenerEventosPorCiudad(String nombreCiudad) throws GestorException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public EventoDTO obtenerEvento(Integer id) throws GestorException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void agregarEvento(EventoDTO evento) throws GestorException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void actualizarEvento(EventoDTO evento) throws GestorException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminarEvento(Integer id) throws GestorException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
