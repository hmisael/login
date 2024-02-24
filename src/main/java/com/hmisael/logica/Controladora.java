package com.hmisael.logica;

import com.hmisael.persistencia.ControladoraPersistencia;
import java.util.List;

/**
 *
 * @author Hernán Misael
 */
public class Controladora {
   
    ControladoraPersistencia controlPersistencia;
    
    public Controladora(){
        controlPersistencia = new ControladoraPersistencia();
    }

    public Usuario validarUsuario(String usuario, String contrasenia) {
        Usuario user = null;      
        List<Usuario> listaUsuarios = controlPersistencia.traerUsuarios();
            
        for (Usuario usu : listaUsuarios){
            //Si el usuario existe
            if (usu.getNombre().equals(usuario)){
                //Si la contraseña del usuario es correcta
                if(usu.getContrasenia().equals(contrasenia)){
                    user = usu;
                    return user;
                }
                else{
                    user = null;
                    return user;
                }
            }
            //Si el usuario no existe
            else{
                user = null;
                //return user;
            }
        }
         return user;
    }

    public List<Usuario> traerUsuarios() {
        return controlPersistencia.traerUsuarios();
    }

    public List<Rol> traerRoles() {
        return controlPersistencia.traerRoles();
    }

    public void crearUsuario(String user, String contrasenia, String rolRecibido) {
        Usuario usuario = new Usuario();
        usuario.setNombre(user);
        usuario.setContrasenia(contrasenia);
        
        //Rol recibido es String. Se procede a buscar el Rol objeto
        Rol rolEncontrado = new Rol();
        rolEncontrado = this.traerRol(rolRecibido);
        //Asignar Rol correspondiente al Usuario
        if (rolEncontrado != null){
            usuario.setUnRol(rolEncontrado);
        }
        
        int id = this.buscarUltimoIdUsuario();
        usuario.setId(id+1);
        
        controlPersistencia.crearUsuario(usuario);
    }

    private Rol traerRol(String rolRecibido) {
        List<Rol> listaRoles = controlPersistencia.traerRoles();
        
        for (Rol rol:listaRoles){
            if (rol.getNombre().equals(rolRecibido)){
                return rol;
            }
        }
        
        return null;
    }

    private int buscarUltimoIdUsuario() {
        List<Usuario> listaUsuarios = this.traerUsuarios();
        Usuario usuario = listaUsuarios.get(listaUsuarios.size()-1);
        return usuario.getId();
    }

    public void borrarUsuario(int idUsuario) {
        controlPersistencia.borrarUsuario(idUsuario);
    }

    public Usuario traerUsuario(int idUsuario) {
        return controlPersistencia.traerUsuario(idUsuario);
    }

    public void modificarUsuario(Usuario usuarioCargado, String usuarioRecibido, String contraseniaRecibida, String rolRecibido) {
        usuarioCargado.setNombre(usuarioRecibido);
        usuarioCargado.setContrasenia(contraseniaRecibida);
        
        //Rol recibido es String. Se procede a buscar el Rol objeto
        Rol rolEncontrado = new Rol();
        rolEncontrado = this.traerRol(rolRecibido);
        //Asignar Rol correspondiente al Usuario
        if (rolEncontrado != null){
            usuarioCargado.setUnRol(rolEncontrado);
        }
        controlPersistencia.modificarUsuario(usuarioCargado);
    }

}
