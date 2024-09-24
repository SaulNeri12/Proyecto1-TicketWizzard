/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.equipo7.proyecto1.ticketwizzard.gestores;

import com.equipo7.proyecto1.ticketwizzard.dao.UsuariosDAO;
import com.equipo7.proyecto1.ticketwizzard.dtos.UsuarioDTO;
import com.equipo7.proyecto1.ticketwizzard.excepciones.DAOException;
import com.equipo7.proyecto1.ticketwizzard.excepciones.GestorException;
import com.equipo7.proyecto1.ticketwizzard.interfaces.dao.IUsuariosDAO;
import com.equipo7.proyecto1.ticketwizzard.interfaces.gestores.IGestorUsuarios;
import com.equipo7.proyecto1.ticketwizzard.objetos.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Equipo 7
 */
public class GestorUsuarios implements IGestorUsuarios {
    private static GestorUsuarios instance;
    
    private IUsuariosDAO usuariosDAO;
    
    private GestorUsuarios() {
        this.usuariosDAO = UsuariosDAO.getInstance();
    }
    
    public static GestorUsuarios getInstance() {
        if (instance == null) {
            instance = new GestorUsuarios();
        }
        
        return instance;
    }
    
    /**
     * Convierte el usuario entidad dado en objeto DTO
     * @param usuario Usuario entidad
     * @return 
     */
    private UsuarioDTO convertirEntidad(Usuario usuario) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        
        usuarioDTO.setId(usuario.getId());
        usuarioDTO.setNombreCompleto(usuario.getNombreCompleto());
        usuarioDTO.setEdad(usuario.getEdad());
        usuarioDTO.setEmail(usuario.getEmail());
        usuarioDTO.setDomicilio(usuario.getDomicilio());
        usuarioDTO.setFechaNacimiento(usuario.getFechaNacimiento());
        usuarioDTO.setSaldo(usuario.getSaldo());
        usuarioDTO.setContrasena(usuario.getContrasena());
        
        return usuarioDTO;
    }
    
    /**
     * Convierte el usuario DTO dado a objeto entidad
     * @param usuario
     * @return 
     */
    private Usuario convertirDTO(UsuarioDTO usuario) {
        Usuario usuarioEnt = new Usuario();
        
        usuarioEnt.setId(usuario.getId());
        usuarioEnt.setNombreCompleto(usuario.getNombreCompleto());
        usuarioEnt.setEdad(usuario.getEdad());
        usuarioEnt.setEmail(usuario.getEmail());
        usuarioEnt.setDomicilio(usuario.getDomicilio());
        usuarioEnt.setFechaNacimiento(usuario.getFechaNacimiento());
        usuarioEnt.setSaldo(usuario.getSaldo());
        usuarioEnt.setContrasena(usuario.getContrasena());
        
        return usuarioEnt;
    }

    @Override
    public List<UsuarioDTO> obtenerUsuariosTodos() throws GestorException {
        try {
            List<Usuario> listaUsuarios = this.usuariosDAO.obtenerUsuariosTodos();
            
            if (listaUsuarios == null || listaUsuarios.isEmpty()) {
                throw new DAOException("No se encontraron usuarios registrados en el sistema");
            }
            
            List<UsuarioDTO> usuarios = new ArrayList<>();
            
            for (Usuario u: listaUsuarios) {
                usuarios.add(this.convertirEntidad(u));
            }
            
            return usuarios;
            
        } catch (DAOException ex) {
            throw new GestorException(ex.getMessage());
        }
    }

    @Override
    public List<UsuarioDTO> obtenerUsuariosPorNombre(String nombreCompleto) throws GestorException {
        try {
            
            if (nombreCompleto == null || nombreCompleto.isBlank()) {
                throw new DAOException("Porfavor, ingrese un nombre valido");
            }
            
            List<Usuario> listaUsuarios = this.usuariosDAO.obtenerUsuariosTodos();
            
            if (listaUsuarios == null || listaUsuarios.isEmpty()) {
                throw new DAOException("No se encontro usuarios con el nombre proporcionado");
            }
            
            List<UsuarioDTO> usuarios = new ArrayList<>();
            
            for (Usuario u: listaUsuarios) {
                usuarios.add(this.convertirEntidad(u));
            }
            
            return usuarios;
        } catch (DAOException ex) {
            throw new GestorException(ex.getMessage());
        }
    }

    @Override
    public UsuarioDTO obtenerUsuario(Integer id) throws GestorException {
        try {
            
            if (id == null || id < 1) {
                throw new DAOException("El usuario no existe");
            }
            
            Usuario usuario = this.usuariosDAO.obtenerUsuario(id);
            
            if (usuario == null) {
                throw new DAOException("No se pudo encontrar al usuario");
            }
            
            return this.convertirEntidad(usuario);
        } catch (DAOException ex) {
            throw new GestorException(ex.getMessage());
        }
    }

    @Override
    public void agregarUsuario(UsuarioDTO usuario) throws GestorException {
        try {
            
            if (usuario == null) {
                throw new DAOException("No se pudo completar el registro de usuario, porfavor intente mas tarde");
            }
            
            this.usuariosDAO.agregarUsuario(this.convertirDTO(usuario));
            
        } catch (DAOException ex) {
            throw new GestorException(ex.getMessage());
        }
    }

    @Override
    public void actualizarUsuario(UsuarioDTO usuario) throws GestorException {
        try {
            
            if (usuario == null) {
                throw new DAOException("No se pudieron modificar las credenciales, porfavor intente mas tarde");
            }
            
            this.usuariosDAO.actualizarUsuario(this.convertirDTO(usuario));
        } catch (DAOException ex) {
            throw new GestorException(ex.getMessage());
        }
    }

    @Override
    public UsuarioDTO iniciarSesion(String email, String contrasena) throws GestorException {
        try {
            
            if (email == null) {
                throw new DAOException("No se ingreso ninguna direccion de correo electronico, porfavor ingrese una");
            }
            
            if (contrasena == null) {
                throw new DAOException("No se ingreso ninguna contrasena, porfavor ingresela");
            }
            
            Usuario usuario = this.usuariosDAO.iniciarSesion(email, contrasena);
            
            UsuarioDTO usuarioDTO = this.convertirEntidad(usuario);
            
            return usuarioDTO;
        } catch (DAOException ex) {
            throw new GestorException(ex.getMessage());
        }
    }

    @Override
    public void aumentarSaldo(Integer idUsuario, Float cantidad) throws GestorException {
        try {
            
            if (idUsuario == null) {
                throw new DAOException("No se pudo aumentar el saldo, porfavor intente mas tarde");
            }
            
            if (cantidad == null || cantidad < 0) {
                throw new DAOException("La cantidad ingresada no es correcta, porfavor ingrese una cantidad valida");
            }
            
            this.usuariosDAO.aumentarSaldo(idUsuario, cantidad);
        } catch (DAOException ex) {
            throw new GestorException(ex.getMessage());
        }
    }
}
