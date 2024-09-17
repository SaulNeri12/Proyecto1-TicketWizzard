
package com.equipo7.proyecto1.ticketwizzard.gestores;

import com.equipo7.proyecto1.ticketwizzard.dtos.UsuarioDTO;
import com.equipo7.proyecto1.ticketwizzard.excepciones.DAOException;
import java.util.List;

/**
 *
 * @author Equipo 7
 */
public interface IGestorUsuarios {
    /**
     * Obtiene todos los usuarios registrados en el sistema
     * @return Lista de usuarios en el sistema, null en caso de no haber ninguno
     * @throws DAOException 
     */
    public List<UsuarioDTO> obtenerUsuariosTodos() throws DAOException;
    
    /**
     * Obtiene los usuarios que coincidan con el nombre especificado
     * @param nombreCompleto 
     * @return Lista de usuarios con coincidencia en el nombre dado, null 
     * si no se encuentra ninguno
     * @throws DAOException
     */
    public List<UsuarioDTO> obtenerUsuariosPorNombre(String nombreCompleto) throws DAOException;
    
    /**
     * Obtiene el usuario con el ID dado
     * @param id ID del usuario a buscar 
     * @return Usuario encontrado, null en caso de no encontrarlo 
     * @throws DAOException 
     */
    public UsuarioDTO obtenerUsuario(Integer id) throws DAOException;

    /**
     * Agrega un usuario al sistema
     * @param usuario Usuario a registrar en el sistema
     * @throws DAOException 
     */
    public void agregarUsuario(UsuarioDTO usuario) throws DAOException;
    
    /**
     * Actualiza la informacion de un usuario en el sistema
     * @param usuario Usuario a modificar
     * @throws DAOException 
     */
    public void actualizarUsuario(UsuarioDTO usuario) throws DAOException;
    
    /**
     * Compara las credenciales dadas para devolver al usuario que hace referencia dichas credenciales
     * @param email Correo electronico del usuario
     * @param contrasena Contrasena del usuario
     * @return Usuario si coinciden, null en caso de no encontrarlo
     * @throws DAOException 
     */
    public UsuarioDTO iniciarSesion(String email, String contrasena) throws DAOException;
}
