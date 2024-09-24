/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.equipo7.proyecto1.ticketwizzard.interfaces.dao;

import com.equipo7.proyecto1.ticketwizzard.excepciones.DAOException;
import com.equipo7.proyecto1.ticketwizzard.objetos.Evento;
import java.util.List;

/**
 *
 * @author Equipo 7
 */
public interface IEventosDAO {
    
    /**
     * Obtiene todos los eventos registrados en el sistema
     * @return
     * @throws DAOException
     */
    public List<Evento> obtenerEventosTodos() throws DAOException;
    
    /**
     * Obtiene los eventos en la ciudad dada
     * @param nombreCiudad Nombre de la ciudad a buscar
     * @return
     * @throws DAOException 
     */
    public List<Evento> obtenerEventosPorCiudad(String nombreCiudad) throws DAOException;
    
    /**
     * Obtiene los eventos en la ciudad indicada
     * @param idCiudad ID de la ciudad a buscar
     * @return
     * @throws DAOException 
     */
    public List<Evento> obtenerEventosPorCiudad(Integer idCiudad) throws DAOException;
    
    /**
     * Obtiene el evento con el ID especificado
     * @param id ID del evento a buscar
     * @return
     * @throws DAOException 
     */
    public Evento obtenerEvento(Integer id) throws DAOException;
    
    /**
     * Agrega un nuevo evento al sistema
     * @param evento Evento a registrar
     * @throws DAOException 
     */
    public void agregarEvento(Evento evento) throws DAOException;
    
    /**
     * Actualiza la informacion de un evento
     * @param evento Evento a actualizar
     * @throws DAOException 
     */
    public void actualizarEvento(Evento evento) throws DAOException;
    
    /**
     * Elimina un evento del sistema
     * @param id ID del evento a eliminar
     * @throws DAOException 
     */
    public void eliminarEvento(Integer id) throws DAOException;
}
