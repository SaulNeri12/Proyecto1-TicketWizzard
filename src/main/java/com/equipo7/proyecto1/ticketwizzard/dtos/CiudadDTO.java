
package com.equipo7.proyecto1.ticketwizzard.dtos;

/**
 *
 * @author Equipo 7
 */
public class CiudadDTO {
    // columna: id_ciudad
    private Integer id;
    // columna: nombre
    private String nombre;
    // columna: estado 
    private String estado;
    
    public CiudadDTO() {
        
    }
    
    public CiudadDTO(String nombre, String estado) {
        this.nombre = nombre;
        this.estado = estado;
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
