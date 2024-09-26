/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.equipo7.proyecto1.ticketwizzard.interfaces.gestores;

import com.equipo7.proyecto1.ticketwizzard.dtos.TransaccionDTO;
import com.equipo7.proyecto1.ticketwizzard.excepciones.GestorException;
import java.util.List;

/**
 *
 * @author Equipo 7
 */
public interface IGestorTransacciones {
    /**
     * Obtiene todas las transacciones que un usuario estuvo involucrado
     * @param idUsuario ID del usuario a buscar
     * @return
     * @throws GestorException
     */
    public List<TransaccionDTO> obtenerTransaccionesUsuario(Integer idUsuario) throws GestorException;
    
    /**
     * Busca una transaccion por su ID
     * @param id ID de la transaccion a buscar
     * @return
     * @throws GestorException
     */
    public TransaccionDTO obtenerTransaccion(Integer id) throws GestorException;
    
    /**
     * Agrega una transaccion al sistema
     * @param transaccion Transaccion a registrar
     * @throws GestorException
     */
    public void agregarTransaccion(TransaccionDTO transaccion) throws GestorException;
    
    /**
     * Actualiza la informacion de una transaccion en el sistema
     * @param transaccion
     * @throws GestorException
     */
    public void actualizarTransaccion(TransaccionDTO transaccion) throws GestorException;
    
    /**
     * Elimina una transaccion del sistema
     * @param id ID de la transaccion a eliminar
     * @throws GestorException 
     */
    public void eliminarTransaccion(Integer id) throws GestorException;
}