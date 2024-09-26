
package com.equipo7.proyecto1.ticketwizzard.dtos;

import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author Equipo 7
 */
public class TransaccionDTO {
    // columna: id_transaccion
    private Integer id;
    // columna: id_comprador
    private UsuarioDTO comprador;
    // columna: id_vendedor
    private UsuarioDTO vendedor;
    // columna: monto
    private Float monto;
    // columna: fecha_hora
    private Timestamp fechaHora;
    // columna: fecha_apartado
    private Date fechaApartado;
    // columna: estado
    private String estado;
    // columna: tipo
    private String tipoTransaccion;
    
    private BoletoDTO boleto;
    
    public TransaccionDTO() {
        
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the comprador
     */
    public UsuarioDTO getComprador() {
        return comprador;
    }

    /**
     * @param comprador the comprador to set
     */
    public void setComprador(UsuarioDTO comprador) {
        this.comprador = comprador;
    }

    /**
     * @return the vendedor
     */
    public UsuarioDTO getVendedor() {
        return vendedor;
    }

    /**
     * @param vendedor the vendedor to set
     */
    public void setVendedor(UsuarioDTO vendedor) {
        this.vendedor = vendedor;
    }

    /**
     * @return the monto
     */
    public Float getMonto() {
        return monto;
    }

    /**
     * @param monto the monto to set
     */
    public void setMonto(Float monto) {
        this.monto = monto;
    }

    /**
     * @return the fechaHora
     */
    public Timestamp getFechaHora() {
        return fechaHora;
    }

    /**
     * @param fechaHora the fechaHora to set
     */
    public void setFechaHora(Timestamp fechaHora) {
        this.fechaHora = fechaHora;
    }

    /**
     * @return the fechaApartado
     */
    public Date getFechaApartado() {
        return fechaApartado;
    }

    /**
     * @param fechaApartado the fechaApartado to set
     */
    public void setFechaApartado(Date fechaApartado) {
        this.fechaApartado = fechaApartado;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the tipoTransaccion
     */
    public String getTipoTransaccion() {
        return tipoTransaccion;
    }

    /**
     * @param tipoTransaccion the tipoTransaccion to set
     */
    public void setTipoTransaccion(String tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    /**
     * @return the boleto
     */
    public BoletoDTO getBoleto() {
        return boleto;
    }

    /**
     * @param boleto the boleto to set
     */
    public void setBoleto(BoletoDTO boleto) {
        this.boleto = boleto;
    }
    
    
}
