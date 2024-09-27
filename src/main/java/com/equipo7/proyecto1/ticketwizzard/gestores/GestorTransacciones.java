
package com.equipo7.proyecto1.ticketwizzard.gestores;

import com.equipo7.proyecto1.ticketwizzard.dao.TransaccionesDAO;
import com.equipo7.proyecto1.ticketwizzard.dtos.AsientoDTO;
import com.equipo7.proyecto1.ticketwizzard.dtos.BoletoDTO;
import com.equipo7.proyecto1.ticketwizzard.dtos.TransaccionDTO;
import com.equipo7.proyecto1.ticketwizzard.dtos.UsuarioDTO;
import com.equipo7.proyecto1.ticketwizzard.excepciones.DAOException;
import com.equipo7.proyecto1.ticketwizzard.excepciones.GestorException;
import com.equipo7.proyecto1.ticketwizzard.interfaces.dao.ITransaccionesDAO;
import com.equipo7.proyecto1.ticketwizzard.interfaces.gestores.IGestorTransacciones;
import com.equipo7.proyecto1.ticketwizzard.objetos.Asiento;
import com.equipo7.proyecto1.ticketwizzard.objetos.Boleto;
import com.equipo7.proyecto1.ticketwizzard.objetos.Transaccion;
import com.equipo7.proyecto1.ticketwizzard.objetos.Usuario;
import java.util.ArrayList;
import java.util.List;
import org.openide.util.Exceptions;

/**
 *
 * @author Equipo 7
 */
public class GestorTransacciones implements IGestorTransacciones {
    private static GestorTransacciones instance;
    
    private ITransaccionesDAO transaccionesDAO;
    
    private GestorTransacciones() {
        this.transaccionesDAO = TransaccionesDAO.getInstance();
    }
    
    public static GestorTransacciones getInstance() {
        if (instance == null) {
            instance = new GestorTransacciones();
        }
        
        return instance;
    }
    
    /**
     * Convierte el transaccion entidad dado en objeto DTO
     * @param transaccion Transaccion entidad
     * @return 
     */
     private TransaccionDTO convertirEntidad(Transaccion transaccion) {
        TransaccionDTO t = new TransaccionDTO();
        
        Boleto boleto = transaccion.getBoleto();
        
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
 
        Usuario comprador = transaccion.getComprador();
        Usuario vendedor = transaccion.getComprador();
        
        UsuarioDTO compradorDTO = new UsuarioDTO();
        compradorDTO.setId(comprador.getId());
        compradorDTO.setNombreCompleto(comprador.getNombreCompleto());
        compradorDTO.setEdad(comprador.getEdad());
        compradorDTO.setEmail(comprador.getEmail());
        compradorDTO.setDomicilio(comprador.getDomicilio());
        compradorDTO.setFechaNacimiento(comprador.getFechaNacimiento());
        compradorDTO.setSaldo(comprador.getSaldo());
        
        if (vendedor != null) {
            UsuarioDTO vendedorDTO = new UsuarioDTO();
            vendedorDTO.setId(vendedor.getId());
            vendedorDTO.setNombreCompleto(vendedor.getNombreCompleto());
            vendedorDTO.setEdad(vendedor.getEdad());
            vendedorDTO.setEmail(vendedor.getEmail());
            vendedorDTO.setDomicilio(vendedor.getDomicilio());
            vendedorDTO.setFechaNacimiento(vendedor.getFechaNacimiento());
            vendedorDTO.setSaldo(vendedor.getSaldo());
            t.setVendedor(vendedorDTO);
        }
        
        t.setComprador(compradorDTO);
        
        
        t.setFechaApartado(transaccion.getFechaApartado());
        t.setFechaHora(transaccion.getFechaHora());
        t.setMonto(transaccion.getMonto());
        t.setTipoTransaccion(transaccion.getTipoTransaccion());
        t.setEstado(transaccion.getEstado());
        t.setId(transaccion.getId());
        t.setBoleto(boletoDTO);
        t.setEstado(transaccion.getEstado());
        
        return t;
    }
    
    /**
     * Convierte el transaccion DTO dado a objeto entidad
     * @param transaccion
     * @return 
     */
    private Transaccion convertirDTO(TransaccionDTO t) {
        Transaccion transaccion = new Transaccion();

        // Convertir BoletoDTO a Boleto
        BoletoDTO boletoDTO = t.getBoleto();
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
        boleto.setAdquiridoBoletera(boletoDTO.getAdquiridoBoletera());

        // Convertir AsientoDTO a Asiento
        AsientoDTO asientoDTO = boletoDTO.getAsiento();
        Asiento asiento = new Asiento();
        asiento.setId(asientoDTO.getId());
        asiento.setFila(asientoDTO.getFila());
        asiento.setNumeroAsiento(asientoDTO.getNumeroAsiento());
        boleto.setAsiento(asiento);

        // Asignar el boleto a la transacción
        transaccion.setBoleto(boleto);

        // Convertir UsuarioDTO a Usuario
        UsuarioDTO compradorDTO = t.getComprador();
        Usuario comprador = new Usuario();
        comprador.setId(compradorDTO.getId());
        comprador.setNombreCompleto(compradorDTO.getNombreCompleto());
        comprador.setEdad(compradorDTO.getEdad());
        comprador.setEmail(compradorDTO.getEmail());
        comprador.setDomicilio(compradorDTO.getDomicilio());
        comprador.setFechaNacimiento(compradorDTO.getFechaNacimiento());
        comprador.setSaldo(compradorDTO.getSaldo());

        if (t.getVendedor() != null) {
            // Hacer lo mismo para el vendedor
            UsuarioDTO vendedorDTO = t.getVendedor();
            Usuario vendedor = new Usuario();
            vendedor.setId(vendedorDTO.getId());
            vendedor.setNombreCompleto(vendedorDTO.getNombreCompleto());
            vendedor.setEdad(vendedorDTO.getEdad());
            vendedor.setEmail(vendedorDTO.getEmail());
            vendedor.setDomicilio(vendedorDTO.getDomicilio());
            vendedor.setFechaNacimiento(vendedorDTO.getFechaNacimiento());
            vendedor.setSaldo(vendedorDTO.getSaldo());
            transaccion.setVendedor(vendedor);
        }

        // Asignar comprador y vendedor a la transacción
        transaccion.setComprador(comprador);
        

        // Asignar otros atributos de la transacción
        transaccion.setFechaApartado(t.getFechaApartado());
        transaccion.setFechaHora(t.getFechaHora());
        transaccion.setMonto(t.getMonto());
        transaccion.setTipoTransaccion(t.getTipoTransaccion());
        transaccion.setEstado(t.getEstado());
        transaccion.setId(t.getId());

        return transaccion;
    }

    @Override
    public List<TransaccionDTO> obtenerTransaccionesUsuario(Integer idUsuario) throws GestorException {
        try {
            List<Transaccion> lista = this.transaccionesDAO.obtenerTransaccionesUsuario(idUsuario);
            
            if (lista.isEmpty()) {
                throw new DAOException("No se encontraron transacciones");
            }
            
            List<TransaccionDTO> transacciones = new ArrayList<>();
            
            for (Transaccion t: lista) {
                transacciones.add(this.convertirEntidad(t));
            }
            
            return transacciones;
        } catch (DAOException ex) {
            throw new GestorException(ex.getMessage());
        }
    }

    @Override
    public TransaccionDTO obtenerTransaccion(Integer id) throws GestorException {
        try {
            Transaccion transaccion = this.transaccionesDAO.obtenerTransaccion(id);
            
            if (transaccion == null) {
                throw new DAOException("No se encontro la transaccion");
            }
            
            return this.convertirEntidad(transaccion);
        } catch (DAOException ex) {
            throw new GestorException(ex.getMessage());
        }
    }

    @Override
    public void agregarTransaccion(TransaccionDTO transaccion) throws GestorException {
        try {
            if (transaccion == null) {
                throw new DAOException("No se pudo agregar transaccion debido a datos erroneos");
            }
            
            this.transaccionesDAO.agregarTransaccion(this.convertirDTO(transaccion));
        } catch (DAOException ex) {
            throw new GestorException(ex.getMessage());
        }
    }

    @Override
    public void actualizarTransaccion(TransaccionDTO transaccion) throws GestorException {
        try {
            if (transaccion == null) {
                throw new DAOException("No se pudo actualizar la informacion de la transaccion debido a la presencia de datos erroneos");
            }
            
            this.transaccionesDAO.actualizarTransaccion(this.convertirDTO(transaccion));
        } catch (DAOException ex) {
            throw new GestorException(ex.getMessage());
        }
    }

    @Override
    public void eliminarTransaccion(Integer id) throws GestorException {
        try {
            if (id == null) {
                throw new DAOException("No se encontro la transaccion que se desea eliminar");
            }
            
            this.transaccionesDAO.eliminarTransaccion(id);
        } catch (DAOException ex) {
            throw new GestorException(ex.getMessage());
        }
    }
}
