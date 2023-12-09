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
@Data //Para la creacion automatica de los set y get de los atributos
@Entity
@Table(name = "producto")
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Long idProducto; // Transforma en id_categoria
    private String descripcion;
    private String detalle;
    private double precio;
    private String rutaImagen;
    private boolean activo;
    


 public Producto() {
    }

    public Producto(String descripcion, String detalle, double precio, String rutaImagen, boolean activo) {
        this.descripcion = descripcion;
        this.detalle = detalle;
        this.precio = precio;
        this.rutaImagen = rutaImagen;
        this.activo = activo;
    }

}
