/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.CarWashGrupo6.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author Vivian
 */
@Data //Para crearcion de SET y GET
@Entity //se le indica que CLIENTE que es la clase se manejara como una entidad
@Table(name = "cliente")//usams el imporor de jakarta, agregamos el nombre de la tabla que en este caso es cliente
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long idCliente;
    //  private String username;
    //  private String password;
    private String nombre;
    private String apellidos;
    private String correo;
    private int telefono;
    private String rutaImagen;
    private boolean activo;

    //consructor vacio sin nada en base
    public Cliente() {
    }

    public Cliente(String nombre, String apellidos, String correo, int telefono, String rutaImagen, boolean activo) {
        // this.username = username;
        // this.password = password;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
        this.rutaImagen = rutaImagen;
        this.activo = activo;
    }

}
