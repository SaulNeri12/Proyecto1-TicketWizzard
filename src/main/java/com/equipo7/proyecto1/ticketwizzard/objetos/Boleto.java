
package com.equipo7.proyecto1.ticketwizzard.objetos;

import java.sql.Date;

/**
 * Clase que representa un boleto en el sistema
 * @author Equipo 7
 */
public class Boleto {
    // columna: id_boleto
    private Integer id;
    // columna: numero_serie
    private String numeroSerie;
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
    // columna: id_usuario (relación con usuario)
    private Integer idUsuario;
    // columna: id_evento (relación con evento)
    private Integer idEvento;
    // columna: id_asiento (relación con asiento)
    private Integer idAsiento;
    // columna: adquirido_boletera
    private Boolean adquiridoBoletera;

    public Boleto() {}

    // Getters y setters para todas las propiedades

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

    public Boolean getAdquiridoBoletera() {
        return adquiridoBoletera;
    }

    public void setAdquiridoBoletera(Boolean adquiridoBoletera) {
        this.adquiridoBoletera = adquiridoBoletera;
    }
    
}
