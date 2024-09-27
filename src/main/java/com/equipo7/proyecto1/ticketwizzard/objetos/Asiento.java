/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.equipo7.proyecto1.ticketwizzard.objetos;

/**
 * Representa un asiento de un evento en el sistema
 * @author neri
 */
public class Asiento {
    private Integer id;
    private String fila;
    private Integer numeroAsiento;
    
    public Asiento() {
        
    }
    
    public Asiento(Integer id, String fila, Integer numeroAsiento) {
        this.id = id;
        this.fila = fila;
        this.numeroAsiento = numeroAsiento;
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
     * @return the fila
     */
    public String getFila() {
        return fila;
    }

    /**
     * @param fila the fila to set
     */
    public void setFila(String fila) {
        this.fila = fila;
    }

    /**
     * @return the numeroAsiento
     */
    public Integer getNumeroAsiento() {
        return numeroAsiento;
    }

    /**
     * @param numeroAsiento the numeroAsiento to set
     */
    public void setNumeroAsiento(Integer numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
    }
    
    
}
