/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.equipo7.proyecto1.ticketwizzard.dao;

import com.equipo7.proyecto1.ticketwizzard.conexion.Conexion;
import com.equipo7.proyecto1.ticketwizzard.dtos.UsuarioDTO;
import com.equipo7.proyecto1.ticketwizzard.excepciones.DAOException;
import com.equipo7.proyecto1.ticketwizzard.interfaces.dao.IUsuariosDAO;
import com.equipo7.proyecto1.ticketwizzard.objetos.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Equipo 7
 */
public class UsuariosDAO implements IUsuariosDAO {
    private Conexion conexion;
    
    public UsuariosDAO(Conexion conexion) {
        this.conexion = conexion;
    }
    
    @Override
    public List<Usuario> obtenerUsuariosTodos() throws DAOException {
        try (Connection c = conexion.obtenerConexion();
                PreparedStatement select = c.prepareStatement(
                "SELECT * FROM usuario;", 
                Statement.RETURN_GENERATED_KEYS)) {
            ResultSet resultados = select.executeQuery();
            
            List<Usuario> usuarios = new ArrayList<>();
            
            while (resultados.next()) {
                Usuario usuario = new Usuario();
                
                usuario.setId(resultados.getInt("id_usuario"));
                usuario.setEmail(resultados.getString("email"));
                usuario.setNombreCompleto(resultados.getString("nombre_completo"));
                usuario.setContrasena(resultados.getString("contrasena"));
                usuario.setFechaNacimiento(resultados.getDate("fecha_nacimiento"));
                usuario.setSaldo(resultados.getFloat("saldo"));
                usuario.setDomicilio(resultados.getString("domicilio"));
                usuario.setEdad(resultados.getInt("edad"));
                
                usuarios.add(usuario);
            }
            
            return usuarios;
            
        } catch (SQLException ex) {
            throw new DAOException("Ocurrio un error al traer la lista de usuarios, intente mas tarde...");
        }
    }

    @Override
    public List<Usuario> obtenerUsuariosPorNombre(String nombreCompleto) throws DAOException {
        try (Connection c = conexion.obtenerConexion();
                PreparedStatement select = c.prepareStatement(
                "SELECT * FROM usuario WHERE nombre LIKE '%?%';", 
                Statement.RETURN_GENERATED_KEYS)) {
            
            // indica el nombre a buscar
            select.setString(1, nombreCompleto);
            
            ResultSet resultados = select.executeQuery();
            
            List<Usuario> usuarios = new ArrayList<>();
            
            while (resultados.next()) {
                Usuario usuario = new Usuario();
                
                usuario.setId(resultados.getInt("id_usuario"));
                usuario.setEmail(resultados.getString("email"));
                usuario.setNombreCompleto(resultados.getString("nombre_completo"));
                usuario.setContrasena(resultados.getString("contrasena"));
                usuario.setFechaNacimiento(resultados.getDate("fecha_nacimiento"));
                usuario.setSaldo(resultados.getFloat("saldo"));
                usuario.setDomicilio(resultados.getString("domicilio"));
                usuario.setEdad(resultados.getInt("edad"));
                
                usuarios.add(usuario);
            }
            
            return usuarios;
            
        } catch (SQLException ex) {
            throw new DAOException("Ocurrio un error al traer la lista de usuarios, intente mas tarde...");
        }
    }

  @Override
public Usuario obtenerUsuario(Integer id) throws DAOException {
    try (Connection c = conexion.obtenerConexion();
            PreparedStatement select = c.prepareStatement(
                "SELECT * FROM usuario WHERE id_usuario = ?;", 
                Statement.RETURN_GENERATED_KEYS)) {
        
        select.setInt(1, id);
        
        ResultSet resultado = select.executeQuery();
        
        if (resultado.next()) {
            Usuario usuario = new Usuario();
            
            usuario.setId(resultado.getInt("id_usuario"));
            usuario.setEmail(resultado.getString("email"));
            usuario.setNombreCompleto(resultado.getString("nombre_completo"));
            usuario.setContrasena(resultado.getString("contrasena"));
            usuario.setFechaNacimiento(resultado.getDate("fecha_nacimiento"));
            usuario.setSaldo(resultado.getFloat("saldo"));
            usuario.setDomicilio(resultado.getString("domicilio"));
            usuario.setEdad(resultado.getInt("edad"));
            
            return usuario;
        } else {
            throw new DAOException("No se encontró el usuario con ID: " + id);
        }
        
    } catch (SQLException ex) {
        throw new DAOException("Error al consultar el usuario: " + ex.getMessage());
    }
}

    @Override
    public void agregarUsuario(UsuarioDTO usuario) throws DAOException {
        try (Connection c = conexion.obtenerConexion();
                PreparedStatement insert = c.prepareStatement(
                   "INSERT INTO usuario(email, nombre_completo, domicilio, fecha_nacimiento, edad, saldo, contrasena) VALUES (?,?,?,?,?,?,?);", 
                   Statement.RETURN_GENERATED_KEYS)) {
           
            insert.setString(1, usuario.getEmail());
            insert.setString(2, usuario.getNombreCompleto());
            insert.setString(3, usuario.getDomicilio());
            insert.setDate(4, usuario.getFechaNacimiento());
            insert.setInt(5, usuario.getEdad());
            insert.setFloat(6, usuario.getSaldo());
            insert.setString(7, usuario.getContrasena());
            
            int insertados = insert.executeUpdate();
            
            if (insertados < 1) {
                throw new DAOException("No se pudo crear la cuenta");
            }
            
        } catch (SQLException ex) {
            //throw new DAOException(ex.getMessage());
            throw new DAOException("Ocurrio un error al intentar registrar el producto, intente mas tarde...");
        }

    }

    @Override
    public void actualizarUsuario(Usuario usuario) throws DAOException {
        try (Connection c = conexion.obtenerConexion();
                PreparedStatement update = c.prepareStatement(
                    "UPDATE usuario SET email=?, nombre_completo=?, domicilio=?, fecha_nacimiento=?,edad=?,saldo=?,contrasena=? WHERE id_usuario = ?;")) {
            
            update.setString(1, usuario.getEmail());
            update.setString(2, usuario.getNombreCompleto());
            update.setString(3, usuario.getDomicilio());
            update.setDate(4, usuario.getFechaNacimiento());
            update.setInt(5, usuario.getEdad());
            update.setFloat(6, usuario.getSaldo());
            update.setString(7, usuario.getContrasena());
            update.setInt(8, usuario.getId());
            
            int modificados = update.executeUpdate();
            
            if (modificados < 1) {
                throw new DAOException("No se encontro la cuenta del usuario");
            }
            
        } catch (SQLException ex) {
            //throw new DAOException(ex.getMessage());
            throw new DAOException("Ocurrio un error al intentar actualizar la informacion del producto, intente mas tarde...");

        }
    }

   @Override
public Usuario iniciarSesion(String email, String contrasena) throws DAOException {
    try (Connection c = conexion.obtenerConexion();
            PreparedStatement select = c.prepareStatement(
                "SELECT * FROM usuario WHERE email = ?;")) {
        
        select.setString(1, email);
        
        ResultSet resultado = select.executeQuery();
        
        if (resultado.next()) {
            Usuario usuario = new Usuario();
            
            usuario.setId(resultado.getInt("id_usuario"));
            usuario.setEmail(resultado.getString("email"));
            usuario.setNombreCompleto(resultado.getString("nombre_completo"));
            usuario.setContrasena(resultado.getString("contrasena"));
            usuario.setFechaNacimiento(resultado.getDate("fecha_nacimiento"));
            usuario.setSaldo(resultado.getFloat("saldo"));
            usuario.setDomicilio(resultado.getString("domicilio"));
            usuario.setEdad(resultado.getInt("edad"));
            
            if (!usuario.getContrasena().equals(contrasena)) {
                throw new DAOException("El correo electrónico o la contraseña son incorrectos");
            }
            
            return usuario;
        }
        
        throw new DAOException("El correo electrónico o la contraseña son incorrectos");
        
    } catch (SQLException ex) {
        throw new DAOException("Error al consultar el usuario: " + ex.getMessage());
    }
}
    
     @Override
    public void aumentarSaldo(Integer idUsuario, Float cantidad) throws DAOException {
        try (Connection c = conexion.obtenerConexion();
             PreparedStatement update = c.prepareStatement(
                "UPDATE usuario SET saldo = saldo + ? WHERE id_usuario = ?;")) {
            
            update.setFloat(1, cantidad);
            update.setInt(2, idUsuario);
            
            int modificados = update.executeUpdate();
            
            if (modificados < 1) {
                throw new DAOException("No se encontró la cuenta del usuario");
            }
            
        } catch (SQLException ex) {
            throw new DAOException("Ocurrió un error al intentar aumentar el saldo, intente más tarde...");
        }
    }
    
}
