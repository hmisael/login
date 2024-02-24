/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hmisael.logica;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Hernán Misael
 */
@Entity
public class Rol implements Serializable {

@Id
//@GeneratedValue(strategy=GenerationType.AUTO)
private int id;
private String nombre;
private String descripcion;

@OneToMany(mappedBy="unRol")
private List<Usuario> listaUsuarios;

    public Rol() {
    }

    public Rol(int id, String nombre, String descripcion, List<Usuario> listaUsuarios) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.listaUsuarios = listaUsuarios;
    }

   

   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }


    



    
}
