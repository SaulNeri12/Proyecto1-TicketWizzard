
package com.equipo7.proyecto1.ticketwizzard.objetos;

import java.sql.Date;

/**
 * Clase que representa un evento en el sistema
 * @author Equipo 7
 */
public class Evento {
    // columna: id_evento
    private Integer id;
    // columna: nombre
    private String nombre;
    // columna: fecha_hora
    private Date fechaHora;
    // columna: descripcion
    private String descripcion;
    // columna: venue
    private String venue;
    // columna: terminado
    private Boolean terminado;
    // columna: id_ciudad
    private Ciudad ciudad;
    // columna: precio_base_boleto
    private Float precioBaseBoleto;
    
    /**
     * Crea una instancia de evento con valores nulos
     */
    public Evento() {
        
    }
    
    
    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
     * @return the fechaHora
     */
    public Date getFechaHora() {
        return fechaHora;
    }

    /**
     * @param fechaHora the fechaHora to set
     */
    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    /**
     * @return the venue
     */
    public String getVenue() {
        return venue;
    }

    /**
     * @param venue the venue to set
     */
    public void setVenue(String venue) {
        this.venue = venue;
    }

    /**
     * @return the terminado
     */
    public Boolean getTerminado() {
        return terminado;
    }

    /**
     * @param terminado the terminado to set
     */
    public void setTerminado(Boolean terminado) {
        this.terminado = terminado;
    }

    /**
     * @return the ciudad
     */
    public Ciudad getCiudad() {
        return ciudad;
    }

    /**
     * @param ciudad the ciudad to set
     */
    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * @return the precioBaseBoleto
     */
    public Float getPrecioBaseBoleto() {
        return precioBaseBoleto;
    }

    /**
     * @param precioBaseBoleto the precioBaseBoleto to set
     */
    public void setPrecioBaseBoleto(Float precioBaseBoleto) {
        this.precioBaseBoleto = precioBaseBoleto;
    }
}
