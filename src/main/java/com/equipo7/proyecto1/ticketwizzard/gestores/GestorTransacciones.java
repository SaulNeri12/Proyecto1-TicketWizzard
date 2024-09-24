/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.equipo7.proyecto1.ticketwizzard.gestores;

import com.equipo7.proyecto1.ticketwizzard.dao.TransaccionesDAO;
import com.equipo7.proyecto1.ticketwizzard.dtos.TransaccionDTO;
import com.equipo7.proyecto1.ticketwizzard.excepciones.GestorException;
import com.equipo7.proyecto1.ticketwizzard.interfaces.dao.ITransaccionesDAO;
import com.equipo7.proyecto1.ticketwizzard.interfaces.gestores.IGestorTransacciones;
import com.equipo7.proyecto1.ticketwizzard.objetos.Transaccion;
import java.util.List;

/**
 *
 * @author Equipo 7
 */
public class GestorTransacciones implements IGestorTransacciones {
    private static GestorTransacciones instance;
    
    private ITransaccionesDAO transaccionesDAO;
    
    private GestorTransacciones() {
        this.transaccionesDAO = TransaccionesDAO.getInstance();
    }
    
    public static GestorTransacciones getInstance() {
        if (instance == null) {
            instance = new GestorTransacciones();
        }
        
        return instance;
    }
    
    /**
     * Convierte el transaccion entidad dado en objeto DTO
     * @param transaccion Transaccion entidad
     * @return 
     */
    private TransaccionDTO convertirEntidad(Transaccion transaccion) {
        return null;
    }
    
    /**
     * Convierte el transaccion DTO dado a objeto entidad
     * @param transaccion
     * @return 
     */
    private Transaccion convertirDTO(TransaccionDTO transaccion) {
        return null;
    }

    @Override
    public List<TransaccionDTO> obtenerTransaccionesUsuario(Integer idUsuario) throws GestorException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<TransaccionDTO> obtenerTransaccion(Integer id) throws GestorException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void agregarTransaccion(TransaccionDTO transaccion) throws GestorException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void actualizarTransaccion(TransaccionDTO transaccion) throws GestorException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminarTransaccion(Integer id) throws GestorException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
