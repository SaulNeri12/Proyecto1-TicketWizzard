/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.equipo7.proyecto1.ticketwizzard.dao;

import com.equipo7.proyecto1.ticketwizzard.criptografia.Encriptador;
import com.equipo7.proyecto1.ticketwizzard.dtos.UsuarioDTO;
import com.equipo7.proyecto1.ticketwizzard.objetos.Usuario;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.fail;


/**
 *
 * @author neri
 */
public class UsuariosDAOTest {
    private UsuariosDAO usuarios;
    
    public UsuariosDAOTest() {
        usuarios = UsuariosDAO.getInstance();
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }

    /**
     * Test of getInstance method, of class UsuariosDAO.
     */
    @org.junit.jupiter.api.Test
    public void testGetInstance() {
        System.out.println("getInstance");
        UsuariosDAO expResult = UsuariosDAO.getInstance();
        UsuariosDAO result = UsuariosDAO.getInstance();
        assertEquals(expResult, result);
    }

    /**
     * Test of obtenerUsuariosTodos method, of class UsuariosDAO.
     */
    @org.junit.jupiter.api.Test
    public void testObtenerUsuariosTodos() throws Exception {
        System.out.println("obtenerUsuariosTodos");
        UsuariosDAO instance = this.usuarios;
        List<Usuario> expResult = null;
        List<Usuario> result = instance.obtenerUsuariosTodos();
        for (Usuario u: result) {
            System.out.println(String.format(
                    "ID: %d, nombre=%s, email=%s, saldo=%.2f", 
                    u.getId(),
                    u.getNombreCompleto(), 
                    u.getEmail(), 
                    u.getSaldo()
            ));
        }
        assertNotSame(expResult, result);
    }

    /**
     * Test of obtenerUsuariosPorNombre method, of class UsuariosDAO.
     */
    @org.junit.jupiter.api.Test
    public void testObtenerUsuariosPorNombre() throws Exception {
        System.out.println("obtenerUsuariosPorNombre");
        String nombreCompleto = "v";
        UsuariosDAO instance = this.usuarios;
        List<Usuario> expResult = null;
        List<Usuario> result = instance.obtenerUsuariosPorNombre(nombreCompleto);
        for (Usuario u: result) {
            System.out.println(String.format(
                    "ID: %d, nombre=%s, email=%s, saldo=%.2f", 
                    u.getId(),
                    u.getNombreCompleto(), 
                    u.getEmail(), 
                    u.getSaldo()
            ));
        }
        assertNotSame(expResult, result);
    }

    /**
     * Test of obtenerUsuario method, of class UsuariosDAO.
     */
    @org.junit.jupiter.api.Test
    public void testObtenerUsuario() throws Exception {
        System.out.println("obtenerUsuario");
        Integer id = 1;
        UsuariosDAO instance = this.usuarios;
        Usuario expResult = null;
        Usuario result = instance.obtenerUsuario(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of agregarUsuario method, of class UsuariosDAO.
     */
    @org.junit.jupiter.api.Test
    public void testAgregarUsuario() throws Exception {
        System.out.println("agregarUsuario");
        UsuarioDTO usuario = null;
        UsuariosDAO instance = null;
        instance.agregarUsuario(usuario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of actualizarUsuario method, of class UsuariosDAO.
     */
    @org.junit.jupiter.api.Test
    public void testActualizarUsuario() throws Exception {
        System.out.println("actualizarUsuario");
        Usuario usuario = null;
        UsuariosDAO instance = null;
        instance.actualizarUsuario(usuario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of iniciarSesion method, of class UsuariosDAO.
     */
    @org.junit.jupiter.api.Test
    public void testIniciarSesion() throws Exception {
        System.out.println("iniciarSesion");
        String email = "juan.perez@example.com";
        String contrasena = "password123";
        UsuariosDAO instance = this.usuarios;
        Usuario expResult = null;
        Usuario result = instance.iniciarSesion(email, contrasena);
        assertNotSame(expResult, result);
    }

    /**
     * Test of aumentarSaldo method, of class UsuariosDAO.
     */
    @org.junit.jupiter.api.Test
    public void testAumentarSaldo() throws Exception {
        System.out.println("aumentarSaldo");
        
        UsuariosDAO instance = this.usuarios;
        
        Integer idUsuario = 1;
        Float cantidad = 200f;
        Usuario usuarioAntes = instance.obtenerUsuario(idUsuario);
        Float saldoAntes = usuarioAntes.getSaldo();
        
        instance.aumentarSaldo(idUsuario, cantidad);
        
        Usuario usuarioDespues = instance.obtenerUsuario(idUsuario);
        Float saldoDespues = usuarioDespues.getSaldo();
        
        Float expResult = saldoAntes + cantidad;
        Float result = saldoDespues;
        
        System.out.println(Encriptador.hash("perro13"));
        
        assertEquals(expResult, result);
    }
    
}
