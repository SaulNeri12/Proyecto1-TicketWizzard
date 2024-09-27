
package com.equipo7.proyecto1.ticketwizzard.interfaces.dao;

import com.equipo7.proyecto1.ticketwizzard.excepciones.DAOException;
import com.equipo7.proyecto1.ticketwizzard.objetos.Transaccion;
import java.util.List;


/**
 * TODO: CUANDO NO SE TIENE DINERO SUFICIENTE, LOS BOLETOS SE APARTAN POR
 * 10 MINUTOS PARA QUE EL USUARIO PUEDA RECARGAR SALDO Y COMPRARLOS
 */

/**
 *
 * @author Equipo 7
 */
public interface ITransaccionesDAO {
    /**
     * Obtiene todas las transacciones que un usuario estuvo involucrado
     * @param idUsuario ID del usuario a buscar
     * @return
     * @throws DAOException 
     */
    public List<Transaccion> obtenerTransaccionesUsuario(Integer idUsuario) throws DAOException;
    
    /**
     * Busca una transaccion por su ID
     * @param id ID de la transaccion a buscar
     * @return
     * @throws DAOException 
     */
    public Transaccion obtenerTransaccion(Integer id) throws DAOException;
    
    /**
     * Agrega una transaccion al sistema
     * @param transaccion Transaccion a registrar
     * @throws DAOException 
     */
    public void agregarTransaccion(Transaccion transaccion) throws DAOException;
    
    /**
     * Actualiza la informacion de una transaccion en el sistema
     * @param transaccion
     * @throws DAOException 
     */
    public void actualizarTransaccion(Transaccion transaccion) throws DAOException;
    
    /**
     * Elimina una transaccion del sistema
     * @param id ID de la transaccion a eliminar
     * @throws DAOException 
     */
    public void eliminarTransaccion(Integer id) throws DAOException;
}
