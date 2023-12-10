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
 * @author quiro
 */
@Data //Para crearcion de SET y GET
@Entity //se le indica que CLIENTE que es la clase se manejara como una entidad
@Table(name = "consulta")
public class Consulta implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_consulta")
    private Long idConsulta;
    private String nombre;
    private String apellidos;
    private String consulta;
    private String correo;

    //consructor vacio sin nada en base
    public Consulta() {
    }

    public Consulta(String nombre, String apellidos, String consulta, String correo) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.consulta = consulta;
        this.correo = correo;
    }

}
