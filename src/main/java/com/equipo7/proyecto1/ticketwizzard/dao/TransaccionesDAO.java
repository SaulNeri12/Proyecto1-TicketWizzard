
package com.equipo7.proyecto1.ticketwizzard.dao;

import com.equipo7.proyecto1.ticketwizzard.conexion.Conexion;
import com.equipo7.proyecto1.ticketwizzard.excepciones.DAOException;
import com.equipo7.proyecto1.ticketwizzard.interfaces.dao.ITransaccionesDAO;
import com.equipo7.proyecto1.ticketwizzard.objetos.Boleto;
import com.equipo7.proyecto1.ticketwizzard.objetos.Transaccion;
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
 * @author neri
 */
public class TransaccionesDAO implements ITransaccionesDAO {
    
    private static String CONSULTAR_TODAS = "SELECT id_transaccion, id_comprador, id_vendedor, id_boleto, monto, fecha_hora, fecha_apartado, estado, tipo FROM transaccion;";
    private static String CONSULTAR_ID = "SELECT id_transaccion, id_comprador, id_vendedor, id_boleto, monto, fecha_hora, fecha_apartado, estado, tipo FROM transaccion WHERE id_transaccion = ?;";
    private static String CONSULTAR_TODAS_USUARIO = "SELECT id_transaccion, id_comprador, id_vendedor, id_boleto, monto, fecha_hora, fecha_apartado, estado, tipo FROM transaccion WHERE id_vendedor = ? OR id_comprador = ?;";    
    private static String INSERTAR = "INSERT INTO transaccion(id_comprador, id_vendedor, id_boleto) VALUES (?,?,?);";
    private static String ACTUALIZAR = "UPDATE transaccion SET id_comprador = ?, id_vendedor = ?, id_boleto = ? WHERE id_transaccion = ?;";
    private static String ELIMINAR = "DELETE FROM transaccion WHERE id_transaccion = ?;";
    
    private static TransaccionesDAO instance;
    private UsuariosDAO usuarios;
    private BoletosDAO boletos;
    
    private Conexion conexion;
    
    private TransaccionesDAO() {
        this.conexion = Conexion.getInstance();
        this.usuarios = UsuariosDAO.getInstance();
        this.boletos = BoletosDAO.getInstance();
    }
    
    public static TransaccionesDAO getInstance() {
        if (instance == null) {
            instance = new TransaccionesDAO(); 
        }
        
        return instance;
    }
    
    /**
     * Devuelve una transaccion completa
     * @param resultados
     * @return
     * @throws DAOException 
     */
    private Transaccion construirTransaccion(ResultSet resultados) throws DAOException {
        Transaccion t = new Transaccion();
        
        try {
            t.setFechaApartado(resultados.getDate("fecha_apartado"));
            t.setFechaHora(resultados.getTimestamp("fecha_hora"));
            t.setTipoTransaccion(resultados.getString("tipo"));
            t.setId(resultados.getInt("id_transaccion"));
            t.setEstado(resultados.getString("estado"));
            t.setMonto(resultados.getFloat("monto"));
        } catch (SQLException ex) {
            throw new DAOException("Ocurrio un error al obtener la informacion de una transaccion, porfavor intente mas tarde...");
        }
        
                
        Integer id_comprador = null, id_vendedor = null, id_boleto = null;
        Usuario comprador = null, vendedor = null;
        Boleto boleto = null;
        
        
        try {
            id_comprador = resultados.getInt("id_comprador");
            comprador = this.usuarios.obtenerUsuario(id_comprador);
        } catch (SQLException ex) { /* no hace nada...*/ }
        
        
        try {
            id_vendedor = resultados.getInt("id_vendedor");
            vendedor = this.usuarios.obtenerUsuario(id_vendedor);
        } catch (SQLException ex) { /* no hace nada...*/ }
        
        
        try {
            id_boleto = resultados.getInt("id_boleto");
            boleto = this.boletos.obtenerBoleto(id_boleto);
        } catch (SQLException ex) { /* no hace nada...*/ }
        
        // no se encuentra informacion de los usuarios que conforman la transaccion...
        if (id_comprador == null && id_vendedor == null || id_boleto == null) {
            throw new DAOException("Ocurrio un error al obtener la informacion de una transaccion, porfavor intente mas tarde...");
        }
        
        
        t.setComprador(comprador);
        t.setVendedor(vendedor);
        t.setBoleto(boleto);
        
        return t;
    }
    
    @Override
    public List<Transaccion> obtenerTransaccionesUsuario(Integer idUsuario) throws DAOException {
        try (Connection c = conexion.obtenerConexion();
                PreparedStatement select = c.prepareStatement(CONSULTAR_TODAS_USUARIO,  
                Statement.RETURN_GENERATED_KEYS)) {
            
            select.setInt(1, idUsuario);
            select.setInt(2, idUsuario);
            
            ResultSet resultados = select.executeQuery();
            
            List<Transaccion> transacciones = new ArrayList<>();
            
            while (resultados.next()) {
                transacciones.add(this.construirTransaccion(resultados));
            }
            
            return transacciones;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new DAOException("Ocurrio un error al traer la lista de transacciones, intente mas tarde...");
        }
    }

    @Override
    public Transaccion obtenerTransaccion(Integer id) throws DAOException {
        try (Connection conn = conexion.obtenerConexion(); PreparedStatement stmt = conn.prepareStatement(CONSULTAR_ID)) {

            stmt.setInt(1, id);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return this.construirTransaccion(rs);
                }
            }
            
            return null;
        } catch (SQLException ex) {
            throw new DAOException("Ocurrio un error al intentar consultar la transaccion, porfavor intente mas tarde...");
        }
    }

    @Override
    public void agregarTransaccion(Transaccion transaccion) throws DAOException {
        try (Connection conn = conexion.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(INSERTAR)) {

            stmt.setInt(1, transaccion.getComprador().getId());
            
            Usuario vendedor = transaccion.getVendedor();
            
            if (vendedor == null || vendedor.getId() == null) {
                stmt.setNull(2, java.sql.Types.INTEGER);
            } else {
                stmt.setInt(2, transaccion.getVendedor().getId());
            }
            
            stmt.setInt(3, transaccion.getBoleto().getId());

            int insertados = stmt.executeUpdate();
            
            if (insertados < 1) {
                throw new DAOException("No se pudo registrar la transaccion...");
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new DAOException("Ocurrio un error al intentar registrar la transaccion, porfavor intente mas tarde...");
        }
    }

    @Override
    public void actualizarTransaccion(Transaccion transaccion) throws DAOException {
         try (Connection conn = conexion.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(ACTUALIZAR)) {

            stmt.setInt(1, transaccion.getComprador().getId());
            
            Usuario vendedor = transaccion.getVendedor();
            if (vendedor == null || vendedor.getId() == null) {
                stmt.setNull(2, java.sql.Types.INTEGER);
            } else {
                stmt.setInt(2, transaccion.getVendedor().getId());
            }
            stmt.setInt(3, transaccion.getBoleto().getId());
            stmt.setInt(4, transaccion.getId());

            int actualizados = stmt.executeUpdate();
            
            if (actualizados < 1) {
                throw new DAOException("No se pudo actualizar la informacion de la transaccion");
            }
            
        } catch (SQLException ex) {
            throw new DAOException("Ocurrio un error al intentar actualizar la transaccion, porfavor intente mas tarde...");
        }
    }

    @Override
    public void eliminarTransaccion(Integer id) throws DAOException {
        try (Connection conn = conexion.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(ELIMINAR)) {
            
            stmt.setInt(1, id);

            int eliminados = stmt.executeUpdate();
            
            if (eliminados < 1) {
                throw new DAOException("No se encontro la transaccion que se desea eliminar");
            }
            
        } catch (SQLException ex) {
            throw new DAOException("Ocurrio un error al intentar eliminar la transaccion, porfavor intente mas tarde...");
        }
    }
}
