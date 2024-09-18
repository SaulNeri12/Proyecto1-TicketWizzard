/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Guis;

/**
 *
 * @author caarl
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      // Iniciar el frame de inicio de sesión en el hilo de la interfaz gráfica
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // Creamos la instancia del frame de inicio de sesión
                frmInicioSesion inicioSesion = new frmInicioSesion();
                
                // Mostramos el frame
                inicioSesion.setVisible(true);
            }
        });
    }
}
