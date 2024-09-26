
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
    // columna: adquirido_boletera
    private Boolean adquiridoBoletera;
    // columna: id_asiento
    private Asiento asiento;

    /**
     * Crea una nueva instancia de boleto con valores nulos
     */
    public Boleto() {}

    /**
     * Obtiene el ID del boleto
     * @return 
     */
    public Integer getId() {
        return id;
    }

    /**
     * Asigna el ID del boleto
     * @param id 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Obtiene el numero de serie del boleto
     * @return 
     */
    public String getNumeroSerie() {
        return numeroSerie;
    }

    /**
     * Asigna el numero de serie del boleto
     * @param numeroSerie
     */
    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    /**
     * Obtiene el numero de control del boleto
     * @return 
     */
    public String getNumeroControl() {
        return numeroControl;
    }

    /**
     * Asigna el numero de control del boleto
     * @param numeroControl 
     */
    public void setNumeroControl(String numeroControl) {
        this.numeroControl = numeroControl;
    }

    /**
     * Obtiene el precio original del boleto
     * @return 
     */
    public Float getPrecioOriginal() {
        return precioOriginal;
    }

    /**
     * Asigna el boleto original del boleto
     * @param precioOriginal 
     */
    public void setPrecioOriginal(Float precioOriginal) {
        this.precioOriginal = precioOriginal;
    }

    /**
     * Obtiene el precio de reventa del boleto
     * @return 
     */
    public Float getPrecioReventa() {
        return precioReventa;
    }

    /**
     * Asigna el precio de reventa del boleto
     * @param precioReventa 
     */
    public void setPrecioReventa(Float precioReventa) {
        this.precioReventa = precioReventa;
    }

    /**
     * Obtiene la fecha limite para la venta del boleto
     * @return 
     */
    public Date getFechaLimiteVenta() {
        return fechaLimiteVenta;
    }

    /**
     * Asigna la fecha limite de venta para el boleto
     * @param fechaLimiteVenta 
     */
    public void setFechaLimiteVenta(Date fechaLimiteVenta) {
        this.fechaLimiteVenta = fechaLimiteVenta;
    }

    /**
     * Obtiene la bandera de si esta en venta el boleto
     * @return true si esta en venta, false caso contrario
     */
    public Boolean getEnVenta() {
        return enVenta;
    }

    /**
     * Asigna el estado de venta del boleto
     * @param enVenta 
     */
    public void setEnVenta(Boolean enVenta) {
        this.enVenta = enVenta;
    }

    /**
     * Obtiene el ID del usuario duenho del boleto
     * @return 
     */
    public Integer getIdUsuario() {
        return idUsuario;
    }

    /**
     * Asigna el ID del propietario del proyecto
     * @param idUsuario 
     */
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * Asigna el ID del evento al cual pertenece el boleto
     * @return 
     */
    public Integer getIdEvento() {
        return idEvento;
    }

    /**
     * Asigna el ID del evento al cual pertence el boleto
     * @param idEvento 
     */
    public void setIdEvento(Integer idEvento) {
        this.idEvento = idEvento;
    }
    
    /**
     * Obtiene el estado si el boleto fue comprado en boletera
     * @return 
     */
    public Boolean getAdquiridoBoletera() {
        return adquiridoBoletera;
    }

    /**
     * Asigna el estado de si el boleto fue comprado en boletera
     * @param adquiridoBoletera 
     */
    public void setAdquiridoBoletera(Boolean adquiridoBoletera) {
        this.adquiridoBoletera = adquiridoBoletera;
    }
    
    /**
     * Obtiene la informacion del asiento del boleto
     * @return Asiento
     */
    public Asiento getAsiento() {
        return asiento;
    }

    /**
     * Asigna el objeto con la informacion del asiento del boleto
     * @param asiento Objeto asiento
     */
    public void setAsiento(Asiento asiento) {
        this.asiento = asiento;
    }
    
    @Override
    public String toString() {
        return String.format(
                "Boleto(id=%d, num_serie=%s, precio_original=%.2f,en_venta=%d,id_usuario=%d, id_asiento=%d, fila=%s, numAsiento=%d)", 
                this.id,this.numeroSerie,this.precioOriginal,this.enVenta ? 1 : 0,this.idUsuario, this.getAsiento().getId(),this.getAsiento().getFila(),this.getAsiento().getNumeroAsiento());
    }


}
