/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.equipo7.proyecto1.ticketwizzard.dao;

import com.equipo7.proyecto1.ticketwizzard.objetos.Boleto;
import com.equipo7.proyecto1.ticketwizzard.objetos.Transaccion;
import com.equipo7.proyecto1.ticketwizzard.objetos.Usuario;
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
public class TransaccionesDAOTest {
    private TransaccionesDAO transacciones;
    
    public TransaccionesDAOTest() {
        this.transacciones = TransaccionesDAO.getInstance();
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
     * Test of obtenerTransaccionesUsuario method, of class TransaccionesDAO.
     */
    @Test
    public void testObtenerTransaccionesUsuario() throws Exception {
        // arrange
        System.out.println("obtenerTransaccionesUsuario");
        Integer idUsuario = 1;
        
        // act
        List<Transaccion> result = this.transacciones.obtenerTransaccionesUsuario(idUsuario);
        for (Transaccion t: result) {
            System.out.println(t);
        }
        // assert
        assertNotNull(result);
    }

    /**
     * Test of obtenerTransaccion method, of class TransaccionesDAO.
     */
    @Test
    public void testObtenerTransaccion() throws Exception {
        // arrange
        System.out.println("obtenerTransaccion");
        Integer id = 1;
        
        // act
        Transaccion result = this.transacciones.obtenerTransaccion(id);
        System.out.println(result);
        
        // assert
        assertNotNull(result);
    }

    /**
     * Test of agregarTransaccion method, of class TransaccionesDAO.
     */
    @Test
    public void testAgregarTransaccion() throws Exception {
        // arrange
        System.out.println("agregarTransaccion");
        Transaccion t = new Transaccion();
        
        Usuario comprador = new Usuario();
        comprador.setId(10); // andres fernandez
        
        Boleto boleto = new Boleto();
        boleto.setId(155);
        
        t.setComprador(comprador);
        t.setBoleto(boleto);
        
        // act
        this.transacciones.agregarTransaccion(t);
        
        // assert
    }

    /**
     * Test of actualizarTransaccion method, of class TransaccionesDAO.
     */
    @Test
    public void testActualizarTransaccion() throws Exception {
        // arrange
        System.out.println("actualizarTransaccion");
        Transaccion t = new Transaccion();
        
        Usuario comprador = new Usuario();
        comprador.setId(1); // andres fernandez
        
        Boleto boleto = new Boleto();
        boleto.setId(30);
        
        t.setId(4);
        t.setComprador(comprador);
        t.setBoleto(boleto);
        
        // act
        this.transacciones.agregarTransaccion(t);
    }

    /**
     * Test of eliminarTransaccion method, of class TransaccionesDAO.
     */
    @Test
    public void testEliminarTransaccion() throws Exception {
        // arrange
        System.out.println("eliminarTransaccion");
        Integer id = 7;
        
        // act
        this.transacciones.eliminarTransaccion(id);
    }
    
}
