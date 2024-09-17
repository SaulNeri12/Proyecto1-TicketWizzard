/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.equipo7.proyecto1.ticketwizzard.gestores;

import com.equipo7.proyecto1.ticketwizzard.dtos.UsuarioDTO;
import com.equipo7.proyecto1.ticketwizzard.excepciones.DAOException;
import com.equipo7.proyecto1.ticketwizzard.excepciones.GestorException;
import com.equipo7.proyecto1.ticketwizzard.interfaces.dao.IUsuariosDAO;
import com.equipo7.proyecto1.ticketwizzard.interfaces.gestores.IGestorUsuarios;
import com.equipo7.proyecto1.ticketwizzard.objetos.Usuario;
import java.util.List;

/**
 *
 * @author Equipo 7
 */
public class GestorUsuarios implements IGestorUsuarios {
    private IUsuariosDAO usuariosDAO;
    
    public GestorUsuarios() {
        
    }
    
    /**
     * Convierte el usuario entidad dado en objeto DTO
     * @param usuario Usuario entidad
     * @return 
     */
    private UsuarioDTO convertirEntidad(Usuario usuario) {
        return null;
    }
    
    /**
     * Convierte el usuario DTO dado a objeto entidad
     * @param usuario
     * @return 
     */
    private Usuario convertirDTO(UsuarioDTO usuario) {
        return null;
    }

    @Override
    public List<UsuarioDTO> obtenerUsuariosTodos() throws GestorException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<UsuarioDTO> obtenerUsuariosPorNombre(String nombreCompleto) throws GestorException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public UsuarioDTO obtenerUsuario(Integer id) throws GestorException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void agregarUsuario(UsuarioDTO usuario) throws GestorException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void actualizarUsuario(UsuarioDTO usuario) throws GestorException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public UsuarioDTO iniciarSesion(String email, String contrasena) throws GestorException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
