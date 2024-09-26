/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.equipo7.proyecto1.ticketwizzard.gestores;

import com.equipo7.proyecto1.ticketwizzard.dao.TransaccionesDAO;
import com.equipo7.proyecto1.ticketwizzard.dtos.TransaccionDTO;
import com.equipo7.proyecto1.ticketwizzard.excepciones.DAOException;
import com.equipo7.proyecto1.ticketwizzard.excepciones.GestorException;
import com.equipo7.proyecto1.ticketwizzard.interfaces.dao.ITransaccionesDAO;
import com.equipo7.proyecto1.ticketwizzard.interfaces.gestores.IGestorTransacciones;
import com.equipo7.proyecto1.ticketwizzard.objetos.Transaccion;
import java.util.ArrayList;
import java.util.List;
import org.openide.util.Exceptions;

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
        try {
            List<Transaccion> lista = this.transaccionesDAO.obtenerTransaccionesUsuario(idUsuario);
            
            if (lista.isEmpty()) {
                throw new DAOException("No se encontraron transacciones");
            }
            
            List<TransaccionDTO> transacciones = new ArrayList<>();
            
            for (Transaccion t: lista) {
                transacciones.add(this.convertirEntidad(t));
            }
            
            return transacciones;
        } catch (DAOException ex) {
            throw new GestorException(ex.getMessage());
        }
    }

    @Override
    public TransaccionDTO obtenerTransaccion(Integer id) throws GestorException {
        try {
            Transaccion transaccion = this.transaccionesDAO.obtenerTransaccion(id);
            
            if (transaccion == null) {
                throw new DAOException("No se encontro la transaccion");
            }
            
            return this.convertirEntidad(transaccion);
        } catch (DAOException ex) {
            throw new GestorException(ex.getMessage());
        }
    }

    @Override
    public void agregarTransaccion(TransaccionDTO transaccion) throws GestorException {
        try {
            if (transaccion == null) {
                throw new DAOException("No se pudo agregar transaccion debido a datos erroneos");
            }
            
            this.transaccionesDAO.agregarTransaccion(this.convertirDTO(transaccion));
        } catch (DAOException ex) {
            throw new GestorException(ex.getMessage());
        }
    }

    @Override
    public void actualizarTransaccion(TransaccionDTO transaccion) throws GestorException {
        try {
            if (transaccion == null) {
                throw new DAOException("No se pudo actualizar la informacion de la transaccion debido a la presencia de datos erroneos");
            }
            
            this.transaccionesDAO.actualizarTransaccion(this.convertirDTO(transaccion));
        } catch (DAOException ex) {
            throw new GestorException(ex.getMessage());
        }
    }

    @Override
    public void eliminarTransaccion(Integer id) throws GestorException {
        try {
            if (id == null) {
                throw new DAOException("No se encontro la transaccion que se desea eliminar");
            }
            
            this.transaccionesDAO.eliminarTransaccion(id);
        } catch (DAOException ex) {
            throw new GestorException(ex.getMessage());
        }
    }
}
