/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.equipo7.proyecto1.ticketwizzard.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Equipo 7
 */
public class Conexion implements IConexion {

    private static Conexion instance;
    
    private String cadenaConexion = "jdbc:mysql://localhost:3306/ticketwizzard";
    private String user = "root";
    private String pwd = "19040042";

    private Conexion() {
        
    }
    
    public static Conexion getInstance() {
        if (instance == null) {
            instance = new Conexion();
        }
        
        return instance;
    }
    
    @Override
    public Connection obtenerConexion() {
        Connection c = null;

        try {
            c = DriverManager.getConnection(cadenaConexion, user, pwd);
        } catch (SQLException ex) {
            
        }

        return c;
    }

}
