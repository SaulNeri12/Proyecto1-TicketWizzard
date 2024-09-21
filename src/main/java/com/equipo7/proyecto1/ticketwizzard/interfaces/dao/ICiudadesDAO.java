/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.equipo7.proyecto1.ticketwizzard.interfaces.dao;

import com.equipo7.proyecto1.ticketwizzard.excepciones.DAOException;
import com.equipo7.proyecto1.ticketwizzard.objetos.Ciudad;
import java.util.List;

/**
 *
 * @author neri
 */
public interface ICiudadesDAO {
    /**
     * Obtiene las ciudades registradas en el sistema
     * @return
     * @throws DAOException 
     */
    public List<Ciudad> obtenerCiudadesTodas() throws DAOException;
    
    /**
     * Agrega una nueva ciudad al sistema
     * @param ciudad Objeto ciudad a registrar
     * @throws DAOException 
     */
    public void agregarCiudad(Ciudad ciudad) throws DAOException;
    
    /**
     * Actualiza la informacion de una ciudad al sistema
     * @param ciudad Objeto ciudad a eliminar
     * @throws DAOException 
     */
    public void actualizarCiudad(Ciudad ciudad) throws DAOException;
    
    /**
     * Elimina una ciudad en el sistema
     * @param id ID de la ciudad a eliminar
     * @throws DAOException 
     */
    public void eliminarCiudad(Integer id) throws DAOException;
}
