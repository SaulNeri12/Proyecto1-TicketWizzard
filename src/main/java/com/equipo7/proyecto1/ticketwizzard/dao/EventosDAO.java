/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.equipo7.proyecto1.ticketwizzard.dao;

import com.equipo7.proyecto1.ticketwizzard.conexion.Conexion;
import com.equipo7.proyecto1.ticketwizzard.excepciones.DAOException;
import com.equipo7.proyecto1.ticketwizzard.interfaces.dao.IEventosDAO;
import com.equipo7.proyecto1.ticketwizzard.objetos.Ciudad;
import com.equipo7.proyecto1.ticketwizzard.objetos.Evento;
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
public class EventosDAO implements IEventosDAO {
    private static EventosDAO instance;
    
    private static final String CONSULTA_TODOS = "SELECT e.id_evento, e.descripcion, e.nombre, e.fecha_hora, e.venue, e.terminado, c.nombre AS ciudad_nombre, c.estado AS ciudad_estado FROM evento e INNER JOIN ciudad c ON e.id_ciudad = c.id_ciudad;";
    private static final String CONSULTA_POR_CIUDAD_STRING = "SELECT e.id_evento, e.descripcion, e.nombre, e.fecha_hora, e.venue, e.terminado, c.nombre AS ciudad_nombre, c.estado AS ciudad_estado FROM evento e INNER JOIN ciudad c ON e.id_ciudad = c.id_ciudad WHERE c.nombre LIKE ?;";
    private static final String CONSULTA_POR_CIUDAD_ID = "SELECT e.id_evento, e.descripcion, e.nombre, e.fecha_hora, e.venue, e.terminado, c.nombre AS ciudad_nombre, c.estado AS ciudad_estado FROM evento e INNER JOIN ciudad c ON e.id_ciudad = c.id_ciudad WHERE e.id_ciudad = ?;";
    private static final String CONSULTA_POR_ID = "SELECT e.id_evento, e.descripcion, e.nombre, e.fecha_hora, e.venue, e.terminado, c.nombre AS ciudad_nombre, c.estado AS ciudad_estado FROM evento e INNER JOIN ciudad c ON e.id_ciudad = c.id_ciudad WHERE e.id_evento = ?;";
    private static final String INSERTAR = "INSERT INTO evento(nombre, descripcion, fecha_hora, venue, terminado, id_ciudad) VALUES (?,?,?,?,?,?);";
    private static final String ACTUALIZAR = "UPDATE evento SET nombre=?, descripcion=?, fecha_hora=?, venue=?, terminado=?, id_ciudad=? WHERE id_evento = ?;";
    private static final String ELIMINAR = "DELETE FROM evento WHERE id_evento = ?;";
    
    private Conexion conexion;
    
    private EventosDAO() {
        this.conexion = Conexion.getInstance();
    }
    
    public static EventosDAO getInstance() {
        if (instance == null) {
            instance = new EventosDAO();
        }
        
        return instance;
    }
    
    private Evento construirEvento(ResultSet resultados) throws SQLException {
        Evento evento = new Evento();
                
        evento.setId(resultados.getInt("id_evento"));
        evento.setNombre(resultados.getString("nombre"));
        evento.setDescripcion(resultados.getString("descripcion"));
        evento.setFechaHora(resultados.getDate("fecha_hora"));
        evento.setTerminado(resultados.getBoolean("terminado"));
        evento.setVenue(resultados.getString("venue"));
        

        Ciudad ciudad = new Ciudad(
                resultados.getInt("id_ciudad"),
                resultados.getString("ciudad_nombre"),
                resultados.getString("ciudad_estado")
        );
        
        evento.setCiudad(ciudad);
        
        return evento;
    }
    
    @Override
    public List<Evento> obtenerEventosTodos() throws DAOException {
        try (Connection c = conexion.obtenerConexion();
                PreparedStatement select = c.prepareStatement(CONSULTA_TODOS,  
                Statement.RETURN_GENERATED_KEYS)) {
            ResultSet resultados = select.executeQuery();
            
            List<Evento> eventos = new ArrayList<>();
            
            while (resultados.next()) {
                eventos.add(this.construirEvento(resultados));
            }
            
            return eventos;
            
        } catch (SQLException ex) {
            throw new DAOException("Ocurrio un error al traer la lista de eventos, intente mas tarde...");
        }
    }

    @Override
    public List<Evento> obtenerEventosPorCiudad(String nombreCiudad) throws DAOException {
        try (Connection c = conexion.obtenerConexion();
                PreparedStatement select = c.prepareStatement(CONSULTA_POR_CIUDAD_STRING,  
                Statement.RETURN_GENERATED_KEYS)) {
            
            select.setString(1, nombreCiudad);
            
            ResultSet resultados = select.executeQuery();
            
            List<Evento> eventos = new ArrayList<>();
            
            while (resultados.next()) {
                eventos.add(this.construirEvento(resultados));
            }
            
            return eventos;
            
        } catch (SQLException ex) {
            throw new DAOException("Ocurrio un error al traer la lista de eventos, intente mas tarde...");
        }
    }
    
    @Override
    public List<Evento> obtenerEventosPorCiudad(Integer idCiudad) throws DAOException {
        try (Connection c = conexion.obtenerConexion();
                PreparedStatement select = c.prepareStatement(CONSULTA_POR_CIUDAD_ID,  
                Statement.RETURN_GENERATED_KEYS)) {
            
            select.setInt(1, idCiudad);
            
            ResultSet resultados = select.executeQuery();
            
            List<Evento> eventos = new ArrayList<>();
            
            while (resultados.next()) {
                eventos.add(this.construirEvento(resultados));
            }
            
            return eventos;
            
        } catch (SQLException ex) {
            throw new DAOException("Ocurrio un error al traer la lista de eventos, intente mas tarde...");
        }
    }

    @Override
    public Evento obtenerEvento(Integer id) throws DAOException {
       try (Connection c = conexion.obtenerConexion();
                PreparedStatement select = c.prepareStatement(CONSULTA_POR_ID,  
                Statement.RETURN_GENERATED_KEYS)) {
            
            select.setInt(1, id);
            
            ResultSet resultados = select.executeQuery();
            
            if (resultados.next()) {
                return this.construirEvento(resultados);
            }
            
            return null;
            
        } catch (SQLException ex) {
            throw new DAOException("Ocurrio un error al consultar al evento, intente mas tarde...");
        }
    }

  @Override 
public void agregarEvento(Evento evento) throws DAOException {
    try (Connection c = conexion.obtenerConexion();
         PreparedStatement insert = c.prepareStatement(
             "INSERT INTO evento (nombre, descripcion, fecha_hora) VALUES (?, ?, ?)",
             Statement.RETURN_GENERATED_KEYS)) {

        insert.setString(1, evento.getNombre());
        insert.setString(2, evento.getDescripcion());
        insert.setTimestamp(3, new java.sql.Timestamp(evento.getFechaHora().getTime())); // Asegúrate de que sea un Timestamp

        int insertados = insert.executeUpdate();

        if (insertados < 1) {
            throw new DAOException("No se pudo registrar el evento");
        }

    } catch (SQLException ex) {
        if (ex.getErrorCode() == 1062) {
            throw new DAOException("El evento que se intenta registrar ya existe");
        }
        throw new DAOException("Ocurrió un error al intentar registrar el evento, intente más tarde...");
    }
}

    @Override
    public void actualizarEvento(Evento evento) throws DAOException {
        try (Connection c = conexion.obtenerConexion();
                PreparedStatement update = c.prepareStatement(
                   ACTUALIZAR, 
                   Statement.RETURN_GENERATED_KEYS)) {
           
            update.setString(1, evento.getNombre());
            update.setString(2, evento.getDescripcion());
            update.setDate(3, evento.getFechaHora());
            update.setString(4, evento.getVenue());
            update.setBoolean(5, evento.getTerminado());
            update.setInt(6, evento.getCiudad().getId());
            update.setInt(7, evento.getId());
            
            int actualizados = update.executeUpdate();
            
            if (actualizados < 1) {
                throw new DAOException("No se pudo actualizar la informacion del evento");
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new DAOException("Ocurrio un error al intentar actualizar la informacion del evento, intente mas tarde...");
        }
    }

    @Override
    public void eliminarEvento(Integer id) throws DAOException {
        try (Connection c = conexion.obtenerConexion();
                PreparedStatement delete = c.prepareStatement(
                   ELIMINAR, 
                   Statement.RETURN_GENERATED_KEYS)) {
           
            delete.setInt(1, id);
            
            int actualizados = delete.executeUpdate();
            
            if (actualizados < 0) {
                throw new DAOException("No se pudo eliminar el evento");
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new DAOException("Ocurrio un error al intentar eliminar el evento, intente mas tarde...");
        }
    }
}
