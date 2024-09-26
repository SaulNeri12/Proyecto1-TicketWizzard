/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.equipo7.proyecto1.ticketwizzard.objetos;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author Equipo 7
 */
public class Transaccion {
    // columna: id_transaccion
    private Integer id;
    // columna: id_comprador
    private Usuario comprador;
    // columna: id_vendedor
    private Usuario vendedor;
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
    
    private Boleto boleto;
    
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
     * @return the comprador
     */
    public Usuario getComprador() {
        return comprador;
    }

    /**
     * @param comprador the comprador to set
     */
    public void setComprador(Usuario comprador) {
        this.comprador = comprador;
    }

    /**
     * @return the vendedor
     */
    public Usuario getVendedor() {
        return vendedor;
    }

    /**
     * @param vendedor the vendedor to set
     */
    public void setVendedor(Usuario vendedor) {
        this.vendedor = vendedor;
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
     * @return the boleto
     */
    public Boleto getBoleto() {
        return boleto;
    }

    /**
     * @param boleto the boleto to set
     */
    public void setBoleto(Boleto boleto) {
        this.boleto = boleto;
    }
    
    @Override
    public String toString() {
        return String.format("Transaccion(id=%d\n, comprador=%s\n, vendedor=%s\n,boleto=%s\n,monto=%.2f\n, estado=%s\n, tipo=%s)", 
                this.id,this.comprador,this.vendedor, this.boleto,this.monto,this.estado,this.tipoTransaccion);
    }
    
}
