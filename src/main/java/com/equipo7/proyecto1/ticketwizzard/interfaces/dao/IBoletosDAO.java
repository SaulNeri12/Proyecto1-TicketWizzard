
package com.equipo7.proyecto1.ticketwizzard.interfaces.dao;

import com.equipo7.proyecto1.ticketwizzard.excepciones.DAOException;
import com.equipo7.proyecto1.ticketwizzard.objetos.Boleto;
import java.util.List;

/**
 * Define las operaciones para un DAO de boletos concreto.
 * @author Equipo 7
 */
public interface IBoletosDAO {
    
    /**
     * Obtiene todos los boletos disponibles para la venta en boletera.
     * @return lista de boletos en venta por la boletera, null si no hay boletos disponibles.
     * @throws DAOException
     */
    public List<Boleto> obtenerBoletosEnVentaBoleteraTodos() throws DAOException;
    
    /**
     * Obtiene los boletos para un evento especificado que están en venta.
     * @param idEvento ID del evento a buscar boletos.
     * @return lista de boletos en venta para el evento, null si no hay boletos disponibles.
     * @throws DAOException 
     */
    public List<Boleto> obtenerBoletosEnVentaEvento(Integer idEvento) throws DAOException;

    /**
     * Obtiene los boletos asociados a un usuario específico.
     * @param idUsuario ID del usuario del cual se quieren obtener los boletos.
     * @return lista de boletos del usuario, null si no tiene boletos.
     * @throws DAOException
     */
    public List<Boleto> obtenerBoletosUsuario(Integer idUsuario) throws DAOException;
    
    /**
     * Obtiene los boletos que están en reventa por los usuarios.
     * @return lista de boletos en reventa, null si no hay boletos en reventa.
     * @throws DAOException
     */
    public List<Boleto> obtenerBoletosEnReventa() throws DAOException;
    
    /**
     * Busca el boleto con el ID especificado.
     * @param id ID del boleto.
     * @return boleto con el ID dado, null en caso de no encontrarlo.
     * @throws DAOException 
     */
    public Boleto obtenerBoleto(Integer id) throws DAOException;
    
    /**
     * Agrega un nuevo boleto al sistema.
     * @param boleto Boleto a agregar.
     * @throws DAOException
     */
    public void agregarBoleto(Boleto boleto) throws DAOException;
    
    /**
     * Actualiza la información de un boleto existente en el sistema.
     * @param boleto Boleto a modificar.
     * @throws DAOException
     */
    public void actualizarBoleto(Boleto boleto) throws DAOException;
    
    /**
     * Elimina el boleto con el ID especificado del sistema.
     * @param id ID del boleto a eliminar.
     * @throws DAOException
     */
    public void eliminarBoleto(Integer id) throws DAOException;
    
    List<Boleto> obtenerBoletosVentaEvento(String nombreEvento) throws DAOException;
    
}
