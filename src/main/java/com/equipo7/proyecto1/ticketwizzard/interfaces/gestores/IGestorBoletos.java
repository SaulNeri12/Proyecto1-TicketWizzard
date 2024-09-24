
package com.equipo7.proyecto1.ticketwizzard.interfaces.gestores;

import com.equipo7.proyecto1.ticketwizzard.dtos.BoletoDTO;
import com.equipo7.proyecto1.ticketwizzard.excepciones.GestorException;
import java.util.List;

/**
 *
 * @author Equipo 7
 */
public interface IGestorBoletos {
    
    /**
     * Obtiene los boletos en venta de los eventos que coincidan con el nombre dado
     * @param nombreEvento Nombre del evento a buscar
     * @return lista de boletos, null si no hay boletos en el sistema
     * @throws GestorException
     */
    public List<BoletoDTO> obtenerBoletosVentaEvento(String nombreEvento) throws GestorException;
    
    /**
     * Obtiene todos los boletos que esten en venta para el evento especificado
     * @param idEvento ID del evento
     * @return
     * @throws GestorException 
     */
    public List<BoletoDTO> obtenerBoletosVentaEvento(Integer idEvento) throws GestorException;
    
    /**
     * Obtiene los boletos del usuario especificado
     * @param idUsuario id del usuario
     * @return Todos los boletos del usuario, null si no tiene boletos
     * @throws GestorException
     */
    public List<BoletoDTO> obtenerBoletosUsuario(Integer idUsuario) throws GestorException;
    
    /**
     * Busca el boleto con el ID especificado
     * @param id ID del boleto
     * @return boleto con el ID dado, null en caso de no encontrarlo
     * @throws GestorException
     */
    public BoletoDTO obtenerBoleto(Integer id) throws GestorException;
    
    /**
     * Agrega un nuevo boleto al sistema
     * @param boleto Boleto a agregar
     * @throws GestorException
     */
    public void agregarBoleto(BoletoDTO boleto) throws GestorException;
    
    /**
     * Actualiza la informacion del boleto especificado
     * @param boleto Boleto a modificar
     * @throws GestorException
     */
    public void actualizarBoleto(BoletoDTO boleto) throws GestorException;
    
    /**
     * Elimina el boleto con el ID especificado
     * @param id ID del boleto a eliminar
     * @throws GestorException
     */
    public void eliminarBoleto(Integer id) throws GestorException;
}
