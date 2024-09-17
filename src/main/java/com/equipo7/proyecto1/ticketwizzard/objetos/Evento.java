
package com.equipo7.proyecto1.ticketwizzard.objetos;

import java.sql.Date;

/**
 *
 * @author Equipo 7
 */
public class Evento {
    // columna: id_evento
    private Integer id;
    // columna: nombre
    private String nombre;
    // columna: fecha
    private String descripcion;

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
}
