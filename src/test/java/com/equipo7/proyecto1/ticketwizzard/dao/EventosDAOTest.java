/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.equipo7.proyecto1.ticketwizzard.dao;

import com.equipo7.proyecto1.ticketwizzard.objetos.Ciudad;
import com.equipo7.proyecto1.ticketwizzard.objetos.Evento;
import java.sql.Date;
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
public class EventosDAOTest {
    private EventosDAO eventos;
    
    public EventosDAOTest() {
        this.eventos = EventosDAO.getInstance();
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
     * Test of obtenerEventosTodos method, of class EventosDAO.
     */
    @Test
    public void testObtenerEventosTodos() throws Exception {
        System.out.println("obtenerEventosTodos");
        EventosDAO instance = this.eventos;
        List<Evento> expResult = null;
        List<Evento> result = instance.obtenerEventosTodos();
        System.out.println(String.format(
                "id: %d, nombre: %s, fecha: %s, ciudad: %s", 
                result.get(0).getId(),
                result.get(0).getNombre(),
                result.get(0).getFechaHora(),
                result.get(0).getCiudad().getNombre()
        ));
        assertNotSame(expResult, result);
    }

    /**
     * Test of obtenerEventosPorCiudad method, of class EventosDAO.
     */
    @Test
    public void testObtenerEventosPorCiudad_String() throws Exception {
        System.out.println("obtenerEventosPorCiudad");
        String nombreCiudad = "puebla";
        EventosDAO instance = this.eventos;
        List<Evento> expResult = null;
        List<Evento> result = instance.obtenerEventosPorCiudad(nombreCiudad);
        System.out.println(String.format(
                "id: %d, nombre: %s, fecha: %s, ciudad: %s", 
                result.get(0).getId(),
                result.get(0).getNombre(),
                result.get(0).getFechaHora(),
                result.get(0).getCiudad().getNombre()
        ));
        assertNotSame(expResult, result);
    }

    /**
     * Test of obtenerEventosPorCiudad method, of class EventosDAO.
     */
    @Test
    public void testObtenerEventosPorCiudad_Integer() throws Exception {
        System.out.println("obtenerEventosPorCiudad");
        Integer idCiudad = 1;
        EventosDAO instance = this.eventos;
        List<Evento> expResult = null;
        List<Evento> result = instance.obtenerEventosPorCiudad(idCiudad);
        System.out.println(String.format(
                "id: %d, nombre: %s, fecha: %s, ciudad: %s", 
                result.get(0).getId(),
                result.get(0).getNombre(),
                result.get(0).getFechaHora(),
                result.get(0).getCiudad().getNombre()
        ));
        assertNotSame(expResult, result);
    }

    /**
     * Test of obtenerEvento method, of class EventosDAO.
     */
    @Test
    public void testObtenerEvento() throws Exception {
        System.out.println("obtenerEvento");
        Integer id = 1;
        EventosDAO instance = this.eventos;
        Evento expResult = null;
        Evento result = instance.obtenerEvento(id);
        System.out.println(String.format(
                "id: %d, nombre: %s, fecha: %s, ciudad: %s", 
                result.getId(),
                result.getNombre(),
                result.getFechaHora(),
                result.getCiudad().getNombre()
        ));
        assertNotSame(expResult, result);
    }

    /**
     * Test of agregarEvento method, of class EventosDAO.
     */
    @Test
    public void testAgregarEvento() throws Exception {
        System.out.println("agregarEvento");
        Evento evento = new Evento();
        EventosDAO instance = this.eventos;
        
        evento.setNombre("Boxeo Libre");
        evento.setDescripcion("Personas del publico se pueden poner los guantes y pelear con el que haya ganado el round anterior");
        evento.setFechaHora(new Date(2024, 11, 10));
        evento.setTerminado(Boolean.FALSE);
        evento.setVenue("Ring de los perros");
        
        Ciudad ciudad = new Ciudad();
        
        ciudad.setId(1); // hermosillo
        
        evento.setCiudad(ciudad);
        
        instance.agregarEvento(evento);
    }

    /**
     * Test of actualizarEvento method, of class EventosDAO.
     */
    @Test
    public void testActualizarEvento() throws Exception {
        System.out.println("actualizarEvento");
        Evento evento = new Evento();
        EventosDAO instance = this.eventos;
        
        evento.setId(10);
        evento.setNombre("Boxeo Libre (REMASTERED)");
        evento.setDescripcion("Personas del publico se pueden poner los guantes y pelear con el que haya ganado el round anterior");
        evento.setFechaHora(new Date(2025, 1, 13));
        evento.setTerminado(Boolean.FALSE);
        evento.setVenue("Ring de los perros 2");
        
        Ciudad ciudad = new Ciudad();
        
        ciudad.setId(1); // hermosillo
        
        evento.setCiudad(ciudad);
        instance.actualizarEvento(evento);
    }

    /**
     * Test of eliminarEvento method, of class EventosDAO.
     */
    @Test
    public void testEliminarEvento() throws Exception {
        System.out.println("eliminarEvento");
        Integer id = 10;
        EventosDAO instance = this.eventos;
        instance.eliminarEvento(id);
    }
    
}
