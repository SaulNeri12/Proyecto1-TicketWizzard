
package com.equipo7.proyecto1.ticketwizzard.interfaces.gestores;

import com.equipo7.proyecto1.ticketwizzard.dtos.UsuarioDTO;
import com.equipo7.proyecto1.ticketwizzard.excepciones.GestorException;
import java.util.List;

/**
 *
 * @author Equipo 7
 */
public interface IGestorUsuarios {
    /**
     * Obtiene todos los usuarios registrados en el sistema
     * @return Lista de usuarios en el sistema, null en caso de no haber ninguno
     * @throws GestorException 
     */
    public List<UsuarioDTO> obtenerUsuariosTodos() throws GestorException;
    
    /**
     * Obtiene los usuarios que coincidan con el nombre especificado
     * @param nombreCompleto 
     * @return Lista de usuarios con coincidencia en el nombre dado, null 
     * si no se encuentra ninguno
     * @throws GestorException
     */
    public List<UsuarioDTO> obtenerUsuariosPorNombre(String nombreCompleto) throws GestorException;
    
    /**
     * Obtiene el usuario con el ID dado
     * @param id ID del usuario a buscar 
     * @return Usuario encontrado, null en caso de no encontrarlo 
     * @throws GestorException 
     */
    public UsuarioDTO obtenerUsuario(Integer id) throws GestorException;

    /**
     * Agrega un usuario al sistema
     * @param usuario Usuario a registrar en el sistema
     * @throws GestorException 
     */
    public void agregarUsuario(UsuarioDTO usuario) throws GestorException;
    
    /**
     * Actualiza la informacion de un usuario en el sistema
     * @param usuario Usuario a modificar
     * @throws GestorException 
     */
    public void actualizarUsuario(UsuarioDTO usuario) throws GestorException;
    
    /**
     * Compara las credenciales dadas para devolver al usuario que hace referencia dichas credenciales
     * @param email Correo electronico del usuario
     * @param contrasena Contrasena del usuario
     * @return Usuario si coinciden, null en caso de no encontrarlo
     * @throws GestorException 
     */
    public UsuarioDTO iniciarSesion(String email, String contrasena) throws GestorException;
}
