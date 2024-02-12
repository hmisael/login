/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hmisael.persistencia;

import com.hmisael.logica.Usuario;
import java.util.List;

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
}
