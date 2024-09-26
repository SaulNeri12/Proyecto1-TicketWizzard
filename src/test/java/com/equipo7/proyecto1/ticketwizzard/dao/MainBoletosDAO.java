/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.equipo7.proyecto1.ticketwizzard.dao;

import com.equipo7.proyecto1.ticketwizzard.dao.BoletosDAO;
import com.equipo7.proyecto1.ticketwizzard.dao.BoletosDAO;
import com.equipo7.proyecto1.ticketwizzard.excepciones.DAOException;
import com.equipo7.proyecto1.ticketwizzard.objetos.Asiento;
import com.equipo7.proyecto1.ticketwizzard.objetos.Boleto;

import java.sql.Date;
import java.util.List;

public class MainBoletosDAO {
    public static void main(String[] args) {
        BoletosDAO boletosDAO = BoletosDAO.getInstance();

        try {
            // 1. Prueba agregar un boleto
            Boleto nuevoBoleto = new Boleto();
            nuevoBoleto.setNumeroSerie("ABC123");
            nuevoBoleto.setNumeroControl("CTRL456");
            nuevoBoleto.setPrecioOriginal(150.00f);
            nuevoBoleto.setPrecioReventa(180.00f);
            nuevoBoleto.setFechaLimiteVenta(Date.valueOf("2024-10-01"));
            nuevoBoleto.setEnVenta(true);
            nuevoBoleto.setIdUsuario(1);
            nuevoBoleto.setIdEvento(1);
            nuevoBoleto.setAsiento(new Asiento(100,null,null));
            nuevoBoleto.setAdquiridoBoletera(false);
            
            boletosDAO.agregarBoleto(nuevoBoleto);
            System.out.println("Boleto agregado con éxito.");

            // 2. Prueba obtener boletos por ID de evento
            int idEvento = 1;
            List<Boleto> boletosEvento = boletosDAO.obtenerBoletosEnVentaEvento(idEvento);
            System.out.println("Boletos para el evento con ID " + idEvento + ":");
            for (Boleto boleto : boletosEvento) {
                System.out.println("ID: " + boleto.getId() + " - Serie: " + boleto.getNumeroSerie() + " - Precio: " + boleto.getPrecioOriginal());
            }

            // 3. Prueba obtener boletos por ID de usuario
            int idUsuario = 1;
            List<Boleto> boletosUsuario = boletosDAO.obtenerBoletosUsuario(idUsuario);
            System.out.println("Boletos del usuario con ID " + idUsuario + ":");
            for (Boleto boleto : boletosUsuario) {
                System.out.println("ID: " + boleto.getId() + " - Serie: " + boleto.getNumeroSerie() + " - Precio: " + boleto.getPrecioOriginal());
            }

            // 4. Prueba obtener un boleto por su ID
            int idBoleto = 1;
            Boleto boleto = boletosDAO.obtenerBoleto(idBoleto);
            if (boleto != null) {
                System.out.println("Boleto obtenido con ID " + idBoleto + ": " + boleto.getNumeroSerie());
            } else {
                System.out.println("No se encontró el boleto con ID " + idBoleto);
            }

            // 5. Prueba actualizar un boleto
            Boleto boletoAActualizar = boletosDAO.obtenerBoleto(idBoleto);
            if (boletoAActualizar != null) {
                boletoAActualizar.setPrecioReventa(200.00f);
                boletosDAO.actualizarBoleto(boletoAActualizar);
                System.out.println("Boleto actualizado con éxito.");
            } else {
                System.out.println("No se pudo actualizar el boleto, no se encontró el ID.");
            }

            // 6. Prueba eliminar un boleto
            int idBoletoAEliminar = 2; // Ajustar este ID para probar
            boletosDAO.eliminarBoleto(idBoletoAEliminar);
            System.out.println("Boleto eliminado con éxito.");

        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
}
