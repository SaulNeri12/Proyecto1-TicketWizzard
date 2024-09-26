
package com.equipo7.proyecto1.ticketwizzard.dtos;

import com.equipo7.proyecto1.ticketwizzard.objetos.*;
import java.sql.Date;

/**
 * Objeto DTO para un boleto en el sistema
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
    private Integer idUsuario;
    private Integer idEvento;
    private Boolean adquiridoBoletera;
    private AsientoDTO asiento;


    public BoletoDTO() {
    
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
    public Integer getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
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
     * @return the asiento
     */
    public AsientoDTO getAsiento() {
        return asiento;
    }

    /**
     * @param asiento the asiento to set
     */
    public void setAsiento(AsientoDTO asiento) {
        this.asiento = asiento;
    }

    
    

}