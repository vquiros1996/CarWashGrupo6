package com.CarWashGrupo6.dao;

/**
 *
 * @author quiro
 */
import com.CarWashGrupo6.domain.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaDao extends JpaRepository <Factura,Long> {
     
}

