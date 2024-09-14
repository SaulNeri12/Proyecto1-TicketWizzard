
package com.equipo7.proyecto1.ticketwizzard.conexion;

import java.sql.Connection;

/**
 *
 * @author Equipo 7
 */
public interface IConexion {
    
    /**
     * Regresa una conexion para interactuar con la base de datos
     * @return Objeto Connection, null en caso de no poder crear la conexion
     */
    public Connection obtenerConexion();
}
