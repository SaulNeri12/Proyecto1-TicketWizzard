
package com.equipo7.proyecto1.ticketwizzard.dtos;

import com.equipo7.proyecto1.ticketwizzard.objetos.*;
import java.sql.Date;

/**
 *
 * @author Equipo 7
 */
public class BoletoDTO {
    private Integer id;
    private String numeroSerie;
    private String numeroControl;
    private Float precioOriginal;
    private Float precioReventa;
    private Date fechaLimiteVenta;
    private Boolean enVenta;
    private Boolean adquiridoBoletera;
    private Integer idUsuario;
    private Integer idEvento;
    private Integer idAsiento;
    private String fila;  
    private Integer numeroAsiento;  

    // Constructor, getters y setters

    public BoletoDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public String getNumeroControl() {
        return numeroControl;
    }

    public void setNumeroControl(String numeroControl) {
        this.numeroControl = numeroControl;
    }

    public Float getPrecioOriginal() {
        return precioOriginal;
    }

    public void setPrecioOriginal(Float precioOriginal) {
        this.precioOriginal = precioOriginal;
    }

    public Float getPrecioReventa() {
        return precioReventa;
    }

    public void setPrecioReventa(Float precioReventa) {
        this.precioReventa = precioReventa;
    }

    public Date getFechaLimiteVenta() {
        return fechaLimiteVenta;
    }

    public void setFechaLimiteVenta(Date fechaLimiteVenta) {
        this.fechaLimiteVenta = fechaLimiteVenta;
    }

    public Boolean getEnVenta() {
        return enVenta;
    }

    public void setEnVenta(Boolean enVenta) {
        this.enVenta = enVenta;
    }

    public Boolean getAdquiridoBoletera() {
        return adquiridoBoletera;
    }

    public void setAdquiridoBoletera(Boolean adquiridoBoletera) {
        this.adquiridoBoletera = adquiridoBoletera;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Integer idEvento) {
        this.idEvento = idEvento;
    }

    public Integer getIdAsiento() {
        return idAsiento;
    }

    public void setIdAsiento(Integer idAsiento) {
        this.idAsiento = idAsiento;
    }

    public String getFila() {
        return fila;
    }

    public void setFila(String fila) {
        this.fila = fila;
    }

    public Integer getNumeroAsiento() {
        return numeroAsiento;
    }

    public void setNumeroAsiento(Integer numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
    }

}