/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.equipo7.proyecto1.ticketwizzard.objetos;

import java.sql.Timestamp;

/**
 *
 * @author Equipo 7
 */
public class Transaccion {
    // columna: id_transaccion
    private Integer id;
    // columna: id_comprador
    private Integer idComprador;
    // columna: id_vendedor
    private Integer idVendedor;
    // columna: id_boleto
    private Integer idBoleto;
    // columna: monto
    private Float monto;
    // columna: fecha_hora
    private Timestamp fechaHora;
    // columna: tipo
    private TipoTransaccion tipoTransaccion;
    
    public Transaccion() {
        
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
     * @return the idComprador
     */
    public Integer getIdComprador() {
        return idComprador;
    }

    /**
     * @param idComprador the idComprador to set
     */
    public void setIdComprador(Integer idComprador) {
        this.idComprador = idComprador;
    }

    /**
     * @return the idVendedor
     */
    public Integer getIdVendedor() {
        return idVendedor;
    }

    /**
     * @param idVendedor the idVendedor to set
     */
    public void setIdVendedor(Integer idVendedor) {
        this.idVendedor = idVendedor;
    }

    /**
     * @return the idBoleto
     */
    public Integer getIdBoleto() {
        return idBoleto;
    }

    /**
     * @param idBoleto the idBoleto to set
     */
    public void setIdBoleto(Integer idBoleto) {
        this.idBoleto = idBoleto;
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
     * @return the tipoTransaccion
     */
    public TipoTransaccion getTipoTransaccion() {
        return tipoTransaccion;
    }

    /**
     * @param tipoTransaccion the tipoTransaccion to set
     */
    public void setTipoTransaccion(TipoTransaccion tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }
    
}
