
package com.CarWashGrupo6.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

@Data //Para crearcion de SET y GET
@Entity //se le indica que CLIENTE que es la clase se manejara como una entidad
@Table(name = "cita")//usams el imporor de jakarta, agregamos el nombre de la tabla que en este caso es cliente
public class Cita implements Serializable {
    
     private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cita")
    private Long idCita;
    //  private String username;
    //  private String password;
    private String nombre;
    private String apellidos;
    private String correo;
    private int telefono;
    private String rutaImagen;
    private boolean activo;

    //consructor vacio sin nada en base
    public Cita() {
    }

    public Cita(String nombre, String apellidos, String correo, int telefono, String rutaImagen, boolean activo) {
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

