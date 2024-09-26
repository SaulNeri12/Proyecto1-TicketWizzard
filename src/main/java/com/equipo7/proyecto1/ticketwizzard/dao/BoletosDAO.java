package com.equipo7.proyecto1.ticketwizzard.dao;

import com.equipo7.proyecto1.ticketwizzard.conexion.Conexion;
import com.equipo7.proyecto1.ticketwizzard.excepciones.DAOException;
import com.equipo7.proyecto1.ticketwizzard.interfaces.dao.IBoletosDAO;
import com.equipo7.proyecto1.ticketwizzard.objetos.Asiento;
import com.equipo7.proyecto1.ticketwizzard.objetos.Boleto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementación concreta del DAO para boletos.
 */
public class BoletosDAO implements IBoletosDAO {
    private static BoletosDAO instance;
    private Conexion conexion;
    
    private BoletosDAO() {
        this.conexion = Conexion.getInstance();
    }
    
    public static BoletosDAO getInstance() {
        if (instance == null) {
            instance = new BoletosDAO();
        }
        return instance;
    }

    public Boleto construirBoleto(ResultSet resultSet) throws SQLException {
        Boleto boleto = new Boleto();
        boleto.setId(resultSet.getInt("id_boleto"));
        boleto.setNumeroSerie(resultSet.getString("numero_serie"));
        boleto.setNumeroControl(resultSet.getString("numero_control"));
        boleto.setPrecioOriginal(resultSet.getFloat("precio_original"));
        boleto.setPrecioReventa(resultSet.getFloat("precio_reventa"));
        boleto.setFechaLimiteVenta(resultSet.getDate("fecha_limite_venta"));
        boleto.setEnVenta(resultSet.getBoolean("en_venta"));
        boleto.setIdUsuario(resultSet.getInt("id_usuario"));
        boleto.setIdEvento(resultSet.getInt("id_evento"));
        
        Asiento asiento = new Asiento(
                resultSet.getInt("id_asiento"), 
                resultSet.getString("fila"), 
                resultSet.getInt("numero")
        );
        
        boleto.setAsiento(asiento);
        boleto.setAdquiridoBoletera(resultSet.getBoolean("adquirido_boletera"));
        
        return boleto;
    }
    
    @Override
    public List<Boleto> obtenerBoletosEnVentaEvento(Integer idEvento) throws DAOException {
        List<Boleto> boletos = new ArrayList<>();
        String sql = "SELECT b.id_boleto,b.numero_serie,b.numero_control,b.precio_original,b.precio_reventa,b.fecha_limite_venta,b.en_venta,b.id_asiento,b.id_usuario,b.id_evento,b.adquirido_boletera,a.fila,a.numero FROM boleto b INNER JOIN asiento a ON b.id_asiento = a.id_asiento WHERE b.id_evento IN (SELECT id_evento FROM evento WHERE id_evento = ?) AND b.en_venta = true;";

        try (Connection conn = conexion.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idEvento);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    boletos.add(this.construirBoleto(rs));
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new DAOException("Error al obtener boletos en venta para el evento con ID: " + idEvento);
        }

        return boletos;
    }

    @Override
    public List<Boleto> obtenerBoletosUsuario(Integer idUsuario) throws DAOException {
        List<Boleto> boletos = new ArrayList<>();
        String sql = "SELECT b.id_boleto,b.numero_serie,b.numero_control,b.precio_original,b.precio_reventa,b.fecha_limite_venta,b.en_venta,b.id_asiento,b.id_usuario,b.id_evento,b.adquirido_boletera,a.fila,a.numero FROM boleto b INNER JOIN asiento a ON b.id_asiento = a.id_asiento WHERE b.id_usuario = ?;";

        try (Connection conn = conexion.obtenerConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idUsuario);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                boletos.add(this.construirBoleto(rs));
            }

        } catch (SQLException ex) {
            throw new DAOException("Error al obtener boletos del usuario con ID: " + idUsuario);
        }

        return boletos;
    }

    @Override
    public Boleto obtenerBoleto(Integer id) throws DAOException {
        Boleto boleto = null;
        String sql = "SELECT b.id_boleto,b.numero_serie,b.numero_control,b.precio_original,b.precio_reventa,b.fecha_limite_venta,b.en_venta,b.id_asiento,b.id_usuario,b.id_evento,b.adquirido_boletera,a.fila,a.numero FROM boleto b INNER JOIN asiento a ON b.id_asiento = a.id_asiento WHERE b.id_boleto = ?";

        try (Connection conn = conexion.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    boleto = this.construirBoleto(rs);
                }
            }
        } catch (SQLException ex) {
            throw new DAOException("Error al obtener el boleto con ID: " + id);
        }

        return boleto;
    }
  
    
    @Override
    public void agregarBoleto(Boleto boleto) throws DAOException {
        String sql = "INSERT INTO boleto (numero_serie, numero_control, precio_original, " +
                "precio_reventa, fecha_limite_venta, en_venta, adquirido_boletera, id_usuario, id_evento, id_asiento) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = conexion.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, boleto.getNumeroSerie());
            stmt.setString(2, boleto.getNumeroControl());
            stmt.setFloat(3, boleto.getPrecioOriginal());
            stmt.setFloat(4, boleto.getPrecioReventa());
            stmt.setDate(5, boleto.getFechaLimiteVenta());
            stmt.setBoolean(6, boleto.getEnVenta());
            stmt.setBoolean(7, boleto.getAdquiridoBoletera());
            stmt.setInt(8, boleto.getIdUsuario());
            stmt.setInt(9, boleto.getIdEvento());
            stmt.setInt(10, boleto.getAsiento().getId());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException("Error al agregar el boleto.");
        }
    }

    @Override
    public void actualizarBoleto(Boleto boleto) throws DAOException {
        String sql = "UPDATE boleto SET numero_serie = ?, numero_control = ?, precio_original = ?, " +
                "precio_reventa = ?, fecha_limite_venta = ?, en_venta = ?, adquirido_boletera = ?, " +
                "id_usuario = ?, id_evento = ?, id_asiento = ? WHERE id_boleto = ?";

        try (Connection conn = conexion.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, boleto.getNumeroSerie());
            stmt.setString(2, boleto.getNumeroControl());
            stmt.setFloat(3, boleto.getPrecioOriginal());
            stmt.setFloat(4, boleto.getPrecioReventa());
            stmt.setDate(5, boleto.getFechaLimiteVenta());
            stmt.setBoolean(6, boleto.getEnVenta());
            stmt.setBoolean(7, boleto.getAdquiridoBoletera());
            stmt.setInt(8, boleto.getIdUsuario());
            stmt.setInt(9, boleto.getIdEvento());
            stmt.setInt(10, boleto.getAsiento().getId());
            stmt.setInt(11, boleto.getId());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException("Error al actualizar el boleto.");
        }
    }

    @Override
    public void eliminarBoleto(Integer id) throws DAOException {
        String sql = "DELETE FROM boleto WHERE id_boleto = ?";

        try (Connection conn = conexion.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException("Error al eliminar el boleto con ID: " + id);
        }
    }
}
