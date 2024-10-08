/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.equipo7.proyecto1.ticketwizzard.objetos;

/**
 * Representa una ciudad en el sistema
 * @author Equipo 7
 */
public class Ciudad {
    // columna: id_ciudad
    private Integer id;
    // columna: nombre
    private String nombre;
    // columna: estado 
    private String estado;
    
    public Ciudad() {
        
    }

    /**
     * Crea una nueva ciudad inicializada con los valores dados
     * @param id ID de la ciudad
     * @param nombre Nombre de la ciudad
     * @param estado Estado en donde se encuentra
     */
    public Ciudad(Integer id, String nombre, String estado) {
        this.id = id;
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

    @Override
    public String toString() {
        return nombre ;
    }
    
    
    
}
