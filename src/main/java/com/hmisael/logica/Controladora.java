/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hmisael.logica;

import com.hmisael.persistencia.ControladoraPersistencia;
import java.util.List;

/**
 *
 * @author Hernán Misael
 */
public class Controladora {
    //ControladoraPersistencia controlPersistencia= new ControladoraPersistencia();
    ControladoraPersistencia controlPersistencia;
    
    public Controladora(){
        controlPersistencia = new ControladoraPersistencia();
    }

    public String validarUsuario(String usuario, String contrasenia) {
        String mensaje = "";
        List<Usuario> listaUsuarios = controlPersistencia.traerUsuarios();
            
        for (Usuario usu : listaUsuarios){
            if (usu.getNombre().equals(usuario)){
                if(usu.getContrasenia().equals(contrasenia)){
                    mensaje = "usuario y contraseña correctos ¡Bienvenido/a!";
                    return mensaje;
                }
                else{
                    mensaje = "Contraseña incorrecta";
                    return mensaje;
                }
            }
            else{
                mensaje = "Usuario no encontrado.";
            }
        }
         return mensaje;
    }
    
}
