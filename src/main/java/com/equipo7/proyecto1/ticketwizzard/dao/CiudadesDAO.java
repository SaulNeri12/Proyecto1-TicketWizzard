/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.equipo7.proyecto1.ticketwizzard.dao;

import com.equipo7.proyecto1.ticketwizzard.conexion.Conexion;
import com.equipo7.proyecto1.ticketwizzard.excepciones.DAOException;
import com.equipo7.proyecto1.ticketwizzard.interfaces.dao.ICiudadesDAO;
import com.equipo7.proyecto1.ticketwizzard.objetos.Ciudad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author neri
 */
public class CiudadesDAO implements ICiudadesDAO {
    private static CiudadesDAO instance;
    
    private static final String CONSULTA_TODOS = "SELECT * FROM ciudad;";
    private static final String INSERTAR = "INSERT INTO ciudad(nombre, estado) VALUES (?,?);";
    private static final String ACTUALIZAR = "UPDATE ciudad SET nombre=?, estado=? WHERE id_ciudad = ?";
    private static final String ELIMINAR = "DELETE FROM ciudad WHERE id_ciudad = ?";
    
    private Conexion conexion;
    
    private CiudadesDAO() {
        this.conexion = Conexion.getInstance();
    }
    
    public static CiudadesDAO getInstance() {
        if (instance == null) {
            instance = new CiudadesDAO();
        }
        
        return instance;
    }
    
    private Ciudad construirCiudad(ResultSet resultados) throws SQLException {
        Ciudad ciudad = new Ciudad(resultados.getString("nombre"), resultados.getString("estado"));
        
        return ciudad;
    }
    
    @Override
    public List<Ciudad> obtenerCiudadesTodas() throws DAOException {
        try (Connection c = conexion.obtenerConexion();
                PreparedStatement select = c.prepareStatement(CONSULTA_TODOS,  
                Statement.RETURN_GENERATED_KEYS)) {
            ResultSet resultados = select.executeQuery();
            
            List<Ciudad> ciudades = new ArrayList<>();
            
            while (resultados.next()) {
                ciudades.add(this.construirCiudad(resultados));
            }
            
            return ciudades;
            
        } catch (SQLException ex) {
            throw new DAOException("Ocurrio un error al traer la lista de ciudades, intente mas tarde...");
        }
    }

    @Override
    public void agregarCiudad(Ciudad ciudad) throws DAOException {
        try (Connection c = conexion.obtenerConexion();
                PreparedStatement insert = c.prepareStatement(
                   INSERTAR, 
                   Statement.RETURN_GENERATED_KEYS)) {
           
            insert.setString(1, ciudad.getNombre());
            insert.setString(2, ciudad.getEstado());
            
            int insertados = insert.executeUpdate();
            
            if (insertados < 1) {
                throw new DAOException("No se pudo registrar la ciudad");
            }
            
        } catch (SQLException ex) {
            if (ex.getErrorCode() == 1062) {
                throw new DAOException("Ya existe una ciudad con ese nombre en el sistema");
            }
            //System.out.println(ex.getMessage());
            throw new DAOException("Ocurrio un error al intentar registrar la ciudad, intente mas tarde...");
        }
    }

    @Override
    public void actualizarCiudad(Ciudad ciudad) throws DAOException {
        try (Connection c = conexion.obtenerConexion();
                PreparedStatement update = c.prepareStatement(
                   ACTUALIZAR, 
                   Statement.RETURN_GENERATED_KEYS)) {
           
            update.setString(1, ciudad.getNombre());
            update.setString(2, ciudad.getEstado());
            update.setInt(3, ciudad.getId());
            
            int actualizados = update.executeUpdate();
            
            if (actualizados < 1) {
                throw new DAOException("No se pudo actualizar la informacion de la ciudad");
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new DAOException("Ocurrio un error al intentar actualizar la informacion de la ciudad, intente mas tarde...");
        }
    }

    @Override
    public void eliminarCiudad(Integer id) throws DAOException {
        try (Connection c = conexion.obtenerConexion();
                PreparedStatement delete = c.prepareStatement(
                   ELIMINAR, 
                   Statement.RETURN_GENERATED_KEYS)) {
           
            delete.setInt(1, id);
            
            int eliminados = delete.executeUpdate();
            
            if (eliminados < 1) {
                throw new DAOException("No se encontro la ciudad en el sistema");
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new DAOException("Ocurrio un error al intentar eliminar la ciudad del sistema, intente mas tarde...");
        }
    }
}
