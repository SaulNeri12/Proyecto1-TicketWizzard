
package com.equipo7.proyecto1.ticketwizzard.objetos;

import java.sql.Date;

/**
 *
 * @author Equipo 7
 */
public class Boleto {
    // columna: id_boleto
    private Integer id;
    // columna: numero_serie
    private String numeroSerie;
    // columna: fila
    private String fila;
    // columna: asiento
    private String asiento;
    // columna: numero_control
    private String numeroControl;
    // columna: precio_original
    private Float precioOriginal;
    // columna: precio_reventa
    private Float precioReventa;
    // columna: fecha_limite_venta
    private Date fechaLimiteVenta;
    // columna: en_venta
    private Boolean enVenta;
    // columna: adquirido_boletera
    private Boolean adquiridoBoletera;
    // columna: id_usuario
    private Float idUsuario;
    //private Usuario usuario;
    // columna: id_evento (evento encapsulado)
    private Integer idEvento;
    
    public Boleto() {
        
    }
    
    /**
     * @return the numeroSerie
     */
    public String getNumeroSerie() {
        return numeroSerie;
    }

    /**
     * @param numeroSerie the numeroSerie to set
     */
    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    /**
     * @return the fila
     */
    public String getFila() {
        return fila;
    }

    /**
     * @param fila the fila to set
     */
    public void setFila(String fila) {
        this.fila = fila;
    }

    /**
     * @return the asiento
     */
    public String getAsiento() {
        return asiento;
    }

    /**
     * @param asiento the asiento to set
     */
    public void setAsiento(String asiento) {
        this.asiento = asiento;
    }

    /**
     * @return the numeroControl
     */
    public String getNumeroControl() {
        return numeroControl;
    }

    /**
     * @param numeroControl the numeroControl to set
     */
    public void setNumeroControl(String numeroControl) {
        this.numeroControl = numeroControl;
    }

    /**
     * @return the precioOriginal
     */
    public Float getPrecioOriginal() {
        return precioOriginal;
    }

    /**
     * @param precioOriginal the precioOriginal to set
     */
    public void setPrecioOriginal(Float precioOriginal) {
        this.precioOriginal = precioOriginal;
    }

    /**
     * @return the precioReventa
     */
    public Float getPrecioReventa() {
        return precioReventa;
    }

    /**
     * @param precioReventa the precioReventa to set
     */
    public void setPrecioReventa(Float precioReventa) {
        this.precioReventa = precioReventa;
    }

    /**
     * @return the fechaLimiteVenta
     */
    public Date getFechaLimiteVenta() {
        return fechaLimiteVenta;
    }

    /**
     * @param fechaLimiteVenta the fechaLimiteVenta to set
     */
    public void setFechaLimiteVenta(Date fechaLimiteVenta) {
        this.fechaLimiteVenta = fechaLimiteVenta;
    }

    /**
     * @return the enVenta
     */
    public Boolean getEnVenta() {
        return enVenta;
    }

    /**
     * @param enVenta the enVenta to set
     */
    public void setEnVenta(Boolean enVenta) {
        this.enVenta = enVenta;
    }

    /**
     * @return the idUsuario
     */
    public Float getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(Float idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * @return the adquiridoBoletera
     */
    public Boolean getAdquiridoBoletera() {
        return adquiridoBoletera;
    }

    /**
     * @param adquiridoBoletera the adquiridoBoletera to set
     */
    public void setAdquiridoBoletera(Boolean adquiridoBoletera) {
        this.adquiridoBoletera = adquiridoBoletera;
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
     * @return the idEvento
     */
    public Integer getIdEvento() {
        return idEvento;
    }

    /**
     * @param idEvento the idEvento to set
     */
    public void setIdEvento(Integer idEvento) {
        this.idEvento = idEvento;
    }
}
