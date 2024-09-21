/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.equipo7.proyecto1.ticketwizzard.dao;

import com.equipo7.proyecto1.ticketwizzard.objetos.Ciudad;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author neri
 */
public class CiudadesDAOTest {
    private CiudadesDAO ciudades;
    
    public CiudadesDAOTest() {
        this.ciudades = CiudadesDAO.getInstance();
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of obtenerCiudadesTodas method, of class CiudadesDAO.
     */
    @Test
    public void testObtenerCiudadesTodas() throws Exception {
        System.out.println("obtenerCiudadesTodas");
        CiudadesDAO instance = this.ciudades;
        List<Ciudad> expResult = null;
        List<Ciudad> result = instance.obtenerCiudadesTodas();
        assertNotSame(expResult, result);
    }

    /**
     * Test of agregarCiudad method, of class CiudadesDAO.
     */
    @Test
    public void testAgregarCiudad() throws Exception {
        System.out.println("agregarCiudad");
        Ciudad ciudad = new Ciudad("Ciudad Obregon", "Sonora");
        CiudadesDAO instance = this.ciudades;
        instance.agregarCiudad(ciudad);
    }

    /**
     * Test of actualizarCiudad method, of class CiudadesDAO.
     */
    @Test
    public void testActualizarCiudad() throws Exception {
        System.out.println("actualizarCiudad");
        Ciudad ciudad = new Ciudad();
        ciudad.setId(29);
        ciudad.setNombre("OBSON");
        ciudad.setEstado("Sonora");
        CiudadesDAO instance = this.ciudades;
        instance.actualizarCiudad(ciudad);
    }

    /**
     * Test of eliminarCiudad method, of class CiudadesDAO.
     */
    @Test
    public void testEliminarCiudad() throws Exception {
        System.out.println("eliminarCiudad");
        Integer id = 27;
        CiudadesDAO instance = this.ciudades;
        instance.eliminarCiudad(id);
    }
    
}
