package com.hmisael.persistencia;

import com.hmisael.logica.Rol;
import com.hmisael.logica.Usuario;
import com.hmisael.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hernán Misael
 */
public class ControladoraPersistencia {
    UsuarioJpaController usuJpa = new UsuarioJpaController();
    RolJpaController rolJpa = new RolJpaController();
    
    public List<Usuario> traerUsuarios() {
        return usuJpa.findUsuarioEntities();
    }

    public List<Rol> traerRoles() {
        return rolJpa.findRolEntities();
    }

    public void crearUsuario(Usuario usuario) {
        usuJpa.create(usuario);
    }

    public void borrarUsuario(int idUsuario) {
        try {
            usuJpa.destroy(idUsuario);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Usuario traerUsuario(int idUsuario) {
        return usuJpa.findUsuario(idUsuario);
    }

    public void modificarUsuario(Usuario usuarioCargado) {
        try {
            usuJpa.edit(usuarioCargado);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
