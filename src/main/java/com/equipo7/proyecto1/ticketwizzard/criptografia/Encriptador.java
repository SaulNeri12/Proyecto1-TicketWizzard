/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.equipo7.proyecto1.ticketwizzard.criptografia;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author neri
 */
public class Encriptador {
    public static String hash(String entradaTexto) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(entradaTexto.getBytes());
            StringBuilder hexString = new StringBuilder();

            // Convertir los bytes a formato hexadecimal
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error al generar la salida encriptada, no se encontro el algoritmo especificado", e);
        }
    }
}
