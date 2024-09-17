
package com.equipo7.proyecto1.ticketwizzard.dao;

import com.equipo7.proyecto1.ticketwizzard.conexion.Conexion;
import com.equipo7.proyecto1.ticketwizzard.excepciones.DAOException;
import com.equipo7.proyecto1.ticketwizzard.interfaces.dao.ITransaccionesDAO;
import com.equipo7.proyecto1.ticketwizzard.objetos.Transaccion;
import java.util.List;

/**
 *
 * @author Equipo 7
 */
public class TransaccionesDAO implements ITransaccionesDAO {
    private Conexion conexion;
    
    public TransaccionesDAO(Conexion conexion) {
        this.conexion = conexion;
    }
    
    @Override
    public List<Transaccion> obtenerTransaccionesUsuario(Integer idUsuario) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Transaccion> obtenerTransaccion(Integer id) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void agregarTransaccion(Transaccion transaccion) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void actualizarTransaccion(Transaccion transaccion) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminarTransaccion(Integer id) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
