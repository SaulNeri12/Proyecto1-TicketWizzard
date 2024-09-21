/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.equipo7.proyecto1.ticketwizzard.interfaces.gestores;

import com.equipo7.proyecto1.ticketwizzard.dtos.EventoDTO;
import com.equipo7.proyecto1.ticketwizzard.excepciones.GestorException;
import java.util.List;

/**
 *
 * @author Equipo 7
 */
public interface IGestorEventos {
    
    /**
     * Obtiene todos los eventos registrados en el sistema
     * @return
     * @throws GestorException
     */
    public List<EventoDTO> obtenerEventosTodos() throws GestorException;
    
    /**
     * Obtiene los eventos en la ciudad dada
     * @param nombreCiudad Nombre de la ciudad a buscar
     * @return
     * @throws GestorException 
     */
    public List<EventoDTO> obtenerEventosPorCiudad(String nombreCiudad) throws GestorException;
    
    /**
     * Obtiene los eventos en la ciudad indicada
     * @param idCiudad ID de la ciudad a buscar
     * @return
     * @throws GestorException 
     */
    public List<EventoDTO> obtenerEventosPorCiudad(Integer idCiudad) throws GestorException;
    
    /**
     * Obtiene el evento con el ID especificado
     * @param id ID del evento a buscar
     * @return
     * @throws GestorException 
     */
    public EventoDTO obtenerEvento(Integer id) throws GestorException;
    
    /**
     * Agrega un nuevo evento al sistema
     * @param evento Evento a registrar
     * @throws GestorException 
     */
    public void agregarEvento(EventoDTO evento) throws GestorException;
    
    /**
     * Actualiza la informacion de un evento
     * @param evento Evento a actualizar
     * @throws GestorException 
     */
    public void actualizarEvento(EventoDTO evento) throws GestorException;
    
    /**
     * Elimina un evento del sistema
     * @param id ID del evento a eliminar
     * @throws GestorException 
     */
    public void eliminarEvento(Integer id) throws GestorException;
}
