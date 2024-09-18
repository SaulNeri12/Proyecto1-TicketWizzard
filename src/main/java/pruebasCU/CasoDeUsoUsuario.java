/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebasCU;

import com.equipo7.proyecto1.ticketwizzard.dtos.UsuarioDTO;
import com.equipo7.proyecto1.ticketwizzard.excepciones.DAOException;
import com.equipo7.proyecto1.ticketwizzard.interfaces.dao.IUsuariosDAO;
import com.equipo7.proyecto1.ticketwizzard.objetos.Usuario;

/**
 *
 * @author caarl
 */
public class CasoDeUsoUsuario {
    private IUsuariosDAO usuariosDAO;

    public CasoDeUsoUsuario(IUsuariosDAO usuariosDAO) {
        this.usuariosDAO = usuariosDAO;
    }

    public void ejecutar() {
        try {
            // Simular entrada de usuario
            String email = "juan.perez@example.com";
            String contrasena = "password123";
            Float cantidadAumentar = 100.0f;

            // Paso 1: Iniciar sesión
            Usuario usuarioLogueado = usuariosDAO.iniciarSesion(email, contrasena);
            System.out.println("Inicio de sesión exitoso para: " + usuarioLogueado.getNombreCompleto());

            // Paso 2: Aumentar saldo
            usuariosDAO.aumentarSaldo(usuarioLogueado.getId(), cantidadAumentar);
            
            // Obtener usuario actualizado
            Usuario usuarioActualizado = usuariosDAO.obtenerUsuario(usuarioLogueado.getId());
            
            // Convertir a DTO para la presentación
            UsuarioDTO usuarioDTO = convertirADTO(usuarioActualizado);
            
            System.out.println("Saldo aumentado exitosamente. Nuevo saldo: " + usuarioDTO.getSaldo());

        } catch (DAOException e) {
            System.out.println("Error en el caso de uso: " + e.getMessage());
            if (e.getCause() != null) {
                System.out.println("Causa del error: " + e.getCause().getMessage());
                e.getCause().printStackTrace();
            }
        }
    }




    private UsuarioDTO convertirADTO(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(usuario.getId());
        dto.setEmail(usuario.getEmail());
        dto.setNombreCompleto(usuario.getNombreCompleto());
        dto.setDomicilio(usuario.getDomicilio());
        dto.setFechaNacimiento(usuario.getFechaNacimiento());
        dto.setEdad(usuario.getEdad());
        dto.setSaldo(usuario.getSaldo());
        // No transferimos la contraseña por seguridad
        return dto;
    }
}