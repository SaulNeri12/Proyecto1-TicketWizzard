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

    String cadenaConexion = "jdbc:mysql://localhost:3306/ticketwizzard";
    String user = "root";
    String pwd = "root";

    public Conexion() {
        
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
