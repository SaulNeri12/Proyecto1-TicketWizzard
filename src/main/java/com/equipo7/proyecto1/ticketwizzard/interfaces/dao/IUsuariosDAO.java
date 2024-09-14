
package com.equipo7.proyecto1.ticketwizzard.interfaces.dao;

import com.equipo7.proyecto1.ticketwizzard.excepciones.DAOException;
import com.equipo7.proyecto1.ticketwizzard.objetos.Usuario;
import java.util.List;

/**
 * Define las operaciones para un DAO de usuarios concreto
 * @author Equipo 7
 */
public interface IUsuariosDAO {
    
    /**
     * Obtiene todos los usuarios registrados en el sistema
     * @return Lista de usuarios en el sistema, null en caso de no haber ninguno
     * @throws DAOException 
     */
    public List<Usuario> obtenerUsuariosTodos() throws DAOException;
    
    /**
     * Obtiene los usuarios que coincidan con el nombre especificado
     * @param nombreCompleto 
     * @return Lista de usuarios con coincidencia en el nombre dado, null 
     * si no se encuentra ninguno
     * @throws DAOException
     */
    public List<Usuario> obtenerUsuariosPorNombre(String nombreCompleto) throws DAOException;
    
    /**
     * Obtiene el usuario con el ID dado
     * @param id ID del usuario a buscar 
     * @return Usuario encontrado, null en caso de no encontrarlo 
     * @throws DAOException 
     */
    public Usuario obtenerUsuario(Integer id) throws DAOException;

    /**
     * Agrega un usuario al sistema
     * @param usuario Usuario a registrar en el sistema
     * @throws DAOException 
     */
    public void agregarUsuario(Usuario usuario) throws DAOException;
    
    /**
     * Actualiza la informacion de un usuario en el sistema
     * @param usuario Usuario a modificar
     * @throws DAOException 
     */
    public void actualizarUsuario(Usuario usuario) throws DAOException;
}





