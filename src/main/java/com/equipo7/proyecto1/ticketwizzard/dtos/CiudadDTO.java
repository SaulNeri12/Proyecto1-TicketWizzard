
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

    public CiudadDTO(Integer id, String nombre, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
      return nombre;
    }


}
