
package com.equipo7.proyecto1.ticketwizzard.interfaces.dao;

import com.equipo7.proyecto1.ticketwizzard.excepciones.DAOException;
import com.equipo7.proyecto1.ticketwizzard.objetos.Presentacion;
import java.util.List;

/**
 *
 * @author Equipo 7
 */
public interface IPresentacionDAO {
    
    /**
     * Obtiene todas las presentaciones de todos los eventos en el sistema...
     * @return
     * @throws DAOException 
     */
    public List<Presentacion> obtenerPresentacionesTodos() throws DAOException;
    
    /**
     * Obtiene las presentaciones que coincidan con el nombre del evento
     * @param nombreEvento Nombre del evento a buscar
     * @return 
     * @throws DAOException 
     */
    public List<Presentacion> obtenerPresentacionesPorNombreEvento(String nombreEvento) throws DAOException;
    
    /**
     * Obtiene las presentaciones en la ciudad especificada
     * @param idCiudad ID de la ciudad a buscar
     * @return
     * @throws DAOException 
     */
    public List<Presentacion> obtenerPresentacionesPorCiudad(Integer idCiudad) throws DAOException;
    
    /**
     * Obtiene las presentaciones del evento especificado
     * @param idEvento ID del evento
     * @return
     * @throws DAOException
     */
    public List<Presentacion> obtenerPresentacionesPorEvento(Integer idEvento) throws DAOException;

    /**
     * Obtiene la presentacion con el ID especificado
     * @param id ID de la presentacion
     * @return
     * @throws DAOException 
     */
    public Presentacion obtenerPresentacion(Integer id) throws DAOException;
    
    /**
     * Agrega una presentacion al sistema
     * @param presentacion Presentacion a agregar
     * @throws DAOException 
     */
    public void agregarPresentacion(Presentacion presentacion) throws DAOException;
    
    /**
     * Actualiza la informacion de la presentacion
     * @param presentacion Presentacion a modificar
     * @throws DAOException 
     */
    public void actualizarPresentacion(Presentacion presentacion) throws DAOException;
    
    /**
     * Elimina la presentacion expecificada del sistema
     * @param id ID de la presentacion
     * @throws DAOException 
     */
    public void eliminarPresentacion(Integer id) throws DAOException;
}
