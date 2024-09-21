/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.equipo7.proyecto1.ticketwizzard.interfaces.gestores;

import com.equipo7.proyecto1.ticketwizzard.dtos.CiudadDTO;
import com.equipo7.proyecto1.ticketwizzard.excepciones.GestorException;
import java.util.List;

/**
 *
 * @author neri
 */
public interface IGestorCiudades {
    /**
     * Obtiene las ciudades registradas en el sistema
     * @return
     * @throws GestorException 
     */
    public List<CiudadDTO> obtenerCiudadesTodas() throws GestorException;
    
    /**
     * Agrega una nueva ciudad al sistema
     * @param ciudad Objeto ciudad a registrar
     * @throws GestorException 
     */
    public void agregarCiudad(CiudadDTO ciudad) throws GestorException;
    
    /**
     * Actualiza la informacion de una ciudad al sistema
     * @param ciudad Objeto ciudad a eliminar
     * @throws GestorException 
     */
    public void actualizarCiudad(CiudadDTO ciudad) throws GestorException;
    
    /**
     * Elimina una ciudad en el sistema
     * @param id ID de la ciudad a eliminar
     * @throws GestorException 
     */
    public void eliminarCiudad(Integer id) throws GestorException;
}
