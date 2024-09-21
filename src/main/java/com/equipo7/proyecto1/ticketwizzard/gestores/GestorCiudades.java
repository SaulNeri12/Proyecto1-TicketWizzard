/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.equipo7.proyecto1.ticketwizzard.gestores;

import com.equipo7.proyecto1.ticketwizzard.dao.CiudadesDAO;
import com.equipo7.proyecto1.ticketwizzard.dtos.CiudadDTO;
import com.equipo7.proyecto1.ticketwizzard.excepciones.DAOException;
import com.equipo7.proyecto1.ticketwizzard.excepciones.GestorException;
import com.equipo7.proyecto1.ticketwizzard.interfaces.dao.ICiudadesDAO;
import com.equipo7.proyecto1.ticketwizzard.interfaces.gestores.IGestorCiudades;
import com.equipo7.proyecto1.ticketwizzard.objetos.Ciudad;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author neri
 */
public class GestorCiudades implements IGestorCiudades {
    private static GestorCiudades instance;
    
    private ICiudadesDAO ciudadesDAO;
    
    private GestorCiudades() {
        this.ciudadesDAO = CiudadesDAO.getInstance();
    }
    
    public static GestorCiudades getInstance() {
        if (instance == null) {
            instance = new GestorCiudades();
        }
        
        return instance;
    }
    
    /**
     * Convierte la ciudad entidad dada en objeto DTO
     * @param ciudad Ciudad entidad
     * @return 
     */
    private CiudadDTO convertirEntidad(Ciudad ciudad) {
        CiudadDTO ciudadDTO = new CiudadDTO(
                ciudad.getNombre(),
                ciudad.getEstado()
        );
        
        return ciudadDTO;
    }
    
    /**
     * Convierte la ciudad DTO dada en objeto entidad
     * @param ciudad Ciudad DTO
     * @return 
     */
    private Ciudad convertirEntidad(CiudadDTO ciudadDTO) {
        Ciudad ciudad = new Ciudad(
                ciudadDTO.getNombre(),
                ciudadDTO.getEstado()
        );
        
        return ciudad;
    }

    @Override
    public List<CiudadDTO> obtenerCiudadesTodas() throws GestorException {
        try {
            List<Ciudad> lista = this.ciudadesDAO.obtenerCiudadesTodas();
            
            if (lista == null || lista.isEmpty()) {
                throw new DAOException("No se encontro ninguna ciudad");
            }
            
            List<CiudadDTO> ciudades = new ArrayList<>();
            
            for (Ciudad c: lista) {
                ciudades.add(this.convertirEntidad(c));
            }
            
            return ciudades;
        } catch (DAOException ex) {
            throw new GestorException(ex.getMessage());
        }
    }

    @Override
    public void agregarCiudad(CiudadDTO ciudad) throws GestorException {
        try {
            if (ciudad == null) {
                throw new DAOException("Los datos de la ciudad estan incompletos o son erroneos, porfavor ingrese la informacion en el formato correcto");
            }
            
            this.ciudadesDAO.agregarCiudad(this.convertirEntidad(ciudad));
        } catch (DAOException ex) {
            throw new GestorException(ex.getMessage());
        }
    }

    @Override
    public void actualizarCiudad(CiudadDTO ciudad) throws GestorException {
        try {
            if (ciudad == null) {
                throw new DAOException("Los datos de la ciudad estan incompletos o son erroneos, porfavor ingrese la informacion en el formato correcto");
            }
            
            this.ciudadesDAO.actualizarCiudad(this.convertirEntidad(ciudad));
        } catch (DAOException ex) {
            throw new GestorException(ex.getMessage());
        }
    }

    @Override
    public void eliminarCiudad(Integer id) throws GestorException {
        try {
            
            if (id == null) {
                throw new DAOException("No se encontro la ciudad indicada");
            }
            
            this.ciudadesDAO.eliminarCiudad(id);
        } catch (DAOException ex) {
            throw new GestorException(ex.getMessage());
        }
    }
}
