
package com.equipo7.proyecto1.ticketwizzard.gestores;

import com.equipo7.proyecto1.ticketwizzard.dao.BoletosDAO;
import com.equipo7.proyecto1.ticketwizzard.dtos.AsientoDTO;
import com.equipo7.proyecto1.ticketwizzard.dtos.BoletoDTO;
import com.equipo7.proyecto1.ticketwizzard.excepciones.DAOException;
import com.equipo7.proyecto1.ticketwizzard.excepciones.GestorException;
import com.equipo7.proyecto1.ticketwizzard.interfaces.dao.IBoletosDAO;
import com.equipo7.proyecto1.ticketwizzard.interfaces.gestores.IGestorBoletos;
import com.equipo7.proyecto1.ticketwizzard.objetos.Asiento;
import com.equipo7.proyecto1.ticketwizzard.objetos.Boleto;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase GestorBoletos que maneja la lógica de negocio para boletos.
 */
public class GestorBoletos implements IGestorBoletos {
    private static GestorBoletos instance;

    private IBoletosDAO boletosDAO;

    private GestorBoletos() {
        this.boletosDAO = BoletosDAO.getInstance();
    }

    public static GestorBoletos getInstance() {
        if (instance == null) {
            instance = new GestorBoletos();
        }
        return instance;
    }

    /**
     * Convierte un objeto Boleto en su correspondiente BoletoDTO.
     *
     * @param boleto Objeto Boleto
     * @return BoletoDTO
     */
    private BoletoDTO convertirEntidad(Boleto boleto) {
        BoletoDTO boletoDTO = new BoletoDTO();
        boletoDTO.setId(boleto.getId());
        boletoDTO.setNumeroSerie(boleto.getNumeroSerie());
        boletoDTO.setNumeroControl(boleto.getNumeroControl());
        boletoDTO.setPrecioOriginal(boleto.getPrecioOriginal());
        boletoDTO.setPrecioReventa(boleto.getPrecioReventa());
        boletoDTO.setFechaLimiteVenta(boleto.getFechaLimiteVenta());
        boletoDTO.setEnVenta(boleto.getEnVenta());
        boletoDTO.setIdUsuario(boleto.getIdUsuario());
        boletoDTO.setIdEvento(boleto.getIdEvento());
        boletoDTO.setAsiento(new AsientoDTO(
                boleto.getAsiento().getId(),
                boleto.getAsiento().getFila(),
                boleto.getAsiento().getNumeroAsiento()
        ));
        boletoDTO.setAdquiridoBoletera(boleto.getAdquiridoBoletera());
        return boletoDTO;
    }

    /**
     * Convierte un objeto BoletoDTO en su correspondiente entidad Boleto.
     *
     * @param boletoDTO BoletoDTO
     * @return Boleto
     */
    private Boleto convertirDTO(BoletoDTO boletoDTO) {
        Boleto boleto = new Boleto();
        boleto.setId(boletoDTO.getId());
        boleto.setNumeroSerie(boletoDTO.getNumeroSerie());
        boleto.setNumeroControl(boletoDTO.getNumeroControl());
        boleto.setPrecioOriginal(boletoDTO.getPrecioOriginal());
        boleto.setPrecioReventa(boletoDTO.getPrecioReventa());
        boleto.setFechaLimiteVenta(boletoDTO.getFechaLimiteVenta());
        boleto.setEnVenta(boletoDTO.getEnVenta());
        boleto.setIdUsuario(boletoDTO.getIdUsuario());
        boleto.setIdEvento(boletoDTO.getIdEvento());
        boleto.setAsiento(new Asiento(
                boletoDTO.getAsiento().getId(),
                boletoDTO.getAsiento().getFila(),
                boletoDTO.getAsiento().getNumeroAsiento()
        ));
        boleto.setAdquiridoBoletera(boletoDTO.getAdquiridoBoletera());
        return boleto;
    }

    @Override
    public List<BoletoDTO> obtenerBoletosVentaEvento(Integer idEvento) throws GestorException {
        try {
            List<Boleto> listaBoletos = this.boletosDAO.obtenerBoletosEnVentaEvento(idEvento);
            if (listaBoletos == null || listaBoletos.isEmpty()) {
                throw new DAOException("No se encontraron boletos para el evento con ID: " + idEvento);
            }
            List<BoletoDTO> boletos = new ArrayList<>();
            for (Boleto boleto : listaBoletos) {
                boletos.add(this.convertirEntidad(boleto));
            }
            return boletos;
        } catch (DAOException ex) {
            throw new GestorException(ex.getMessage());
        }
    }

    @Override
    public List<BoletoDTO> obtenerBoletosUsuario(Integer idUsuario) throws GestorException {
        try {
            List<Boleto> listaBoletos = this.boletosDAO.obtenerBoletosUsuario(idUsuario);
            if (listaBoletos == null || listaBoletos.isEmpty()) {
                throw new DAOException("No se encontraron boletos para el usuario con ID: " + idUsuario);
            }
            List<BoletoDTO> boletos = new ArrayList<>();
            for (Boleto boleto : listaBoletos) {
                boletos.add(this.convertirEntidad(boleto));
            }
            return boletos;
        } catch (DAOException ex) {
            throw new GestorException(ex.getMessage());
        }
    }

    @Override
    public BoletoDTO obtenerBoleto(Integer id) throws GestorException {
        try {
            Boleto boleto = this.boletosDAO.obtenerBoleto(id);
            if (boleto == null) {
                throw new DAOException("No se encontró el boleto con ID: " + id);
            }
            return this.convertirEntidad(boleto);
        } catch (DAOException ex) {
            throw new GestorException(ex.getMessage());
        }
    }

    @Override
    public void agregarBoleto(BoletoDTO boletoDTO) throws GestorException {
        try {
            if (boletoDTO == null) {
                throw new DAOException("La información del boleto es incorrecta o está incompleta.");
            }
            this.boletosDAO.agregarBoleto(this.convertirDTO(boletoDTO));
        } catch (DAOException ex) {
            throw new GestorException(ex.getMessage());
        }
    }

    @Override
    public void actualizarBoleto(BoletoDTO boletoDTO) throws GestorException {
        try {
            if (boletoDTO == null) {
                throw new DAOException("La información del boleto es incorrecta o está incompleta.");
            }
            this.boletosDAO.actualizarBoleto(this.convertirDTO(boletoDTO));
        } catch (DAOException ex) {
            throw new GestorException(ex.getMessage());
        }
    }

    @Override
    public void eliminarBoleto(Integer id) throws GestorException {
        try {
            if (id == null) {
                throw new DAOException("El ID del boleto es incorrecto.");
            }
            this.boletosDAO.eliminarBoleto(id);
        } catch (DAOException ex) {
            throw new GestorException(ex.getMessage());
        }
    }
}
