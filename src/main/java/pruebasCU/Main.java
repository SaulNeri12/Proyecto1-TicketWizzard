/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebasCU;

import com.equipo7.proyecto1.ticketwizzard.conexion.Conexion;
import com.equipo7.proyecto1.ticketwizzard.dao.UsuariosDAO;
import com.equipo7.proyecto1.ticketwizzard.interfaces.dao.IUsuariosDAO;

/**
 *
 * @author caarl
 */
public class Main {
    public static void main(String[] args) {
        IUsuariosDAO usuariosDAO = UsuariosDAO.getInstance();
        CasoDeUsoUsuario casoDeUso = new CasoDeUsoUsuario(usuariosDAO);

        casoDeUso.ejecutar();
    }
}