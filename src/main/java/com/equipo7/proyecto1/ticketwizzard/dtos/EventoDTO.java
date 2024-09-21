
package com.equipo7.proyecto1.ticketwizzard.dtos;

import com.equipo7.proyecto1.ticketwizzard.objetos.*;
import java.sql.Date;

/**
 *
 * @author Equipo 7
 */
public class EventoDTO {
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
   
    private CiudadDTO ciudad;

    public EventoDTO() {
        
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
    public CiudadDTO getCiudad() {
        return ciudad;
    }

    /**
     * @param ciudad the ciudad to set
     */
    public void setCiudad(CiudadDTO ciudad) {
        this.ciudad = ciudad;
    }
}
