package com.CarWashGrupo6.dao;

import com.CarWashGrupo6.domain.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author quiro
 */
public interface ProductoDao extends JpaRepository<Producto, Long> {

    public List<Producto> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup);

    
}
