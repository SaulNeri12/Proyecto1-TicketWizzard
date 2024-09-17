
package com.equipo7.proyecto1.ticketwizzard.gestores;

import com.equipo7.proyecto1.ticketwizzard.dtos.BoletoDTO;
import com.equipo7.proyecto1.ticketwizzard.excepciones.GestorException;
import com.equipo7.proyecto1.ticketwizzard.interfaces.dao.IBoletosDAO;
import com.equipo7.proyecto1.ticketwizzard.interfaces.gestores.IGestorBoletos;
import com.equipo7.proyecto1.ticketwizzard.objetos.Boleto;
import java.util.List;

/**
 *
 * @author Equipo 7
 */
public class GestorBoletos implements IGestorBoletos {
    private IBoletosDAO boletosDAO;
    
    public GestorBoletos() {
        
    }
    
    /**
     * Convierte el boleto entidad dado en objeto DTO
     * @param boleto Boleto entidad
     * @return 
     */
    private BoletoDTO convertirEntidad(Boleto boleto) {
        return null;
    }
    
    /**
     * Convierte el boleto DTO dado a objeto entidad
     * @param boleto
     * @return 
     */
    private Boleto convertirDTO(BoletoDTO boleto) {
        return null;
    }
    
    
    @Override
    public List<BoletoDTO> obtenerBoletosVentaEvento(String nombreEvento) throws GestorException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<BoletoDTO> obtenerBoletosVentaEvento(Integer idEvento) throws GestorException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<BoletoDTO> obtenerBoletosUsuario(Integer idUsuario) throws GestorException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public BoletoDTO obtenerBoleto(Integer id) throws GestorException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void agregarBoleto(BoletoDTO boleto) throws GestorException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void actualizarBoleto(BoletoDTO boleto) throws GestorException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminarBoleto(Integer id) throws GestorException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
