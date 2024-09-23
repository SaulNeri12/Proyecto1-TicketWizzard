package com.equipo7.proyecto1.ticketwizzard.dao;

import com.equipo7.proyecto1.ticketwizzard.conexion.Conexion;
import com.equipo7.proyecto1.ticketwizzard.excepciones.DAOException;
import com.equipo7.proyecto1.ticketwizzard.interfaces.dao.IBoletosDAO;
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

    @Override
    public List<Boleto> obtenerBoletosEnVentaBoleteraTodos() throws DAOException {
        List<Boleto> boletos = new ArrayList<>();
        String sql = "SELECT * FROM boletos WHERE en_venta = true AND adquirido_boletera = true";

        try (Connection conn = conexion.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                boletos.add(convertirResultSetABoleto(rs));
            }
        } catch (SQLException ex) {
            throw new DAOException("Error al obtener boletos en venta por boletera.");
        }

        return boletos;
    }

    @Override
    public List<Boleto> obtenerBoletosEnVentaEvento(Integer idEvento) throws DAOException {
        List<Boleto> boletos = new ArrayList<>();
        String sql = "SELECT * FROM boletos WHERE id_evento = ? AND en_venta = true";

        try (Connection conn = conexion.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idEvento);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    boletos.add(convertirResultSetABoleto(rs));
                }
            }
        } catch (SQLException ex) {
            throw new DAOException("Error al obtener boletos en venta para el evento con ID: " + idEvento);
        }

        return boletos;
    }

    @Override
    public List<Boleto> obtenerBoletosUsuario(Integer idUsuario) throws DAOException {
        List<Boleto> boletos = new ArrayList<>();
        String sql = "SELECT * FROM boletos WHERE id_usuario = ?";

        try (Connection conn = conexion.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idUsuario);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    boletos.add(convertirResultSetABoleto(rs));
                }
            }
        } catch (SQLException ex) {
            throw new DAOException("Error al obtener boletos del usuario con ID: " + idUsuario);
        }

        return boletos;
    }

    @Override
    public List<Boleto> obtenerBoletosEnReventa() throws DAOException {
        List<Boleto> boletos = new ArrayList<>();
        String sql = "SELECT * FROM boletos WHERE en_venta = true AND adquirido_boletera = false";

        try (Connection conn = conexion.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                boletos.add(convertirResultSetABoleto(rs));
            }
        } catch (SQLException ex) {
            throw new DAOException("Error al obtener boletos en reventa.");
        }

        return boletos;
    }

    @Override
    public Boleto obtenerBoleto(Integer id) throws DAOException {
        Boleto boleto = null;
        String sql = "SELECT * FROM boletos WHERE id_boleto = ?";

        try (Connection conn = conexion.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    boleto = convertirResultSetABoleto(rs);
                }
            }
        } catch (SQLException ex) {
            throw new DAOException("Error al obtener el boleto con ID: " + id);
        }

        return boleto;
    }
    
    @Override
    public List<Boleto> obtenerBoletosVentaEvento(String nombreEvento) throws DAOException {
        List<Boleto> boletos = new ArrayList<>();
        String sql = "SELECT * FROM boletos WHERE id_evento IN (SELECT id FROM eventos WHERE nombre = ?) AND en_venta = true";

        try (Connection conn = conexion.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

           stmt.setString(1, nombreEvento);
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                Boleto boleto = new Boleto();
                boleto.setId(resultSet.getInt("id"));
                boleto.setNumeroSerie(resultSet.getString("numero_serie"));
                boleto.setNumeroControl(resultSet.getString("numero_control"));
                boleto.setPrecioOriginal(resultSet.getFloat("precio_original"));
                boleto.setPrecioReventa(resultSet.getFloat("precio_reventa"));
                boleto.setFechaLimiteVenta(resultSet.getDate("fecha_limite_venta"));
                boleto.setEnVenta(resultSet.getBoolean("en_venta"));
                boleto.setIdUsuario(resultSet.getInt("id_usuario"));
                boleto.setIdEvento(resultSet.getInt("id_evento"));
                boleto.setIdAsiento(resultSet.getInt("id_asiento"));
                boleto.setAdquiridoBoletera(resultSet.getBoolean("adquirido_boletera"));
                
                boletos.add(boleto);
            }
        } catch (Exception e) {
            throw new DAOException("Error al obtener boletos para el evento: " + nombreEvento);
        }

        return boletos;
    }
    

    @Override
    public void agregarBoleto(Boleto boleto) throws DAOException {
        String sql = "INSERT INTO boletos (numero_serie, numero_control, precio_original, " +
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
            stmt.setInt(10, boleto.getIdAsiento());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException("Error al agregar el boleto.");
        }
    }

    @Override
    public void actualizarBoleto(Boleto boleto) throws DAOException {
        String sql = "UPDATE boletos SET numero_serie = ?, numero_control = ?, precio_original = ?, " +
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
            stmt.setInt(10, boleto.getIdAsiento());
            stmt.setInt(11, boleto.getId());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException("Error al actualizar el boleto.");
        }
    }

    @Override
    public void eliminarBoleto(Integer id) throws DAOException {
        String sql = "DELETE FROM boletos WHERE id_boleto = ?";

        try (Connection conn = conexion.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException("Error al eliminar el boleto con ID: " + id);
        }
    }

    /**
     * Convierte un ResultSet en un objeto Boleto.
     * @param rs ResultSet con la información del boleto.
     * @return Objeto Boleto.
     * @throws SQLException
     */
    private Boleto convertirResultSetABoleto(ResultSet rs) throws SQLException {
        Boleto boleto = new Boleto();
        boleto.setId(rs.getInt("id_boleto"));
        boleto.setNumeroSerie(rs.getString("numero_serie"));
        boleto.setNumeroControl(rs.getString("numero_control"));
        boleto.setPrecioOriginal(rs.getFloat("precio_original"));
        boleto.setPrecioReventa(rs.getFloat("precio_reventa"));
        boleto.setFechaLimiteVenta(rs.getDate("fecha_limite_venta"));
        boleto.setEnVenta(rs.getBoolean("en_venta"));
        boleto.setAdquiridoBoletera(rs.getBoolean("adquirido_boletera"));
        boleto.setIdUsuario(rs.getInt("id_usuario"));
        boleto.setIdEvento(rs.getInt("id_evento"));
        boleto.setIdAsiento(rs.getInt("id_asiento"));

        return boleto;
    }
    
    
}
