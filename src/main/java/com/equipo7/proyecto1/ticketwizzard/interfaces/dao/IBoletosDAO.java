/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.equipo7.proyecto1.ticketwizzard.interfaces.dao;

import com.equipo7.proyecto1.ticketwizzard.excepciones.DAOException;
import com.equipo7.proyecto1.ticketwizzard.objetos.Boleto;
import java.util.List;

/**
 * Define las operaciones para un DAO de boletos concreto
 * @author Equipo 7
 */
public interface IBoletosDAO {
    /**
     * Obtiene los boletos en venta en boletera
     * @return lista de boletos, null si no hay boletos en el sistema
     * @throws DAOException
     */
    public List<Boleto> obtenerBoletosEnVentaBoletera() throws DAOException;
    
    /**
     * Obtiene los boletos del usuario especificado
     * @param idUsuario id del usuario
     * @return Todos los boletos del usuario, null si no tiene boletos
     * @throws DAOException
     */
    public List<Boleto> obtenerBoletosUsuario(Integer idUsuario) throws DAOException;
    
    /**
     * Obtiene los boletos en venta por parte de los usuarios
     * @return Boletos del usuario en venta, null si no tiene boletos en venta
     * @throws DAOException
     */
    public List<Boleto> obtenerBoletosEnReventa() throws DAOException;
    
    /**
     * Busca el boleto con el ID especificado
     * @param id ID del boleto
     * @return boleto con el ID dado, null en caso de no encontrarlo
     * @throws DAOException 
     */
    public Boleto buscarBoleto(Integer id) throws DAOException;
    
    /**
     * Agrega un nuevo boleto al sistema
     * @param boleto Boleto a agregar
     * @throws DAOException
     */
    public void agregarBoleto(Boleto boleto) throws DAOException;
    
    /**
     * Actualiza la informacion del boleto especificado
     * @param boleto Boleto a modificar
     * @throws DAOException
     */
    public void actualizarBoleto(Boleto boleto) throws DAOException;
    
    /**
     * Elimina el boleto con el ID especificado
     * @param id ID del boleto a eliminar
     * @throws DAOException
     */
    public void eliminarBoleto(Integer id) throws DAOException;
}
