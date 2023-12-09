package com.CarWashGrupo6.service;

import com.CarWashGrupo6.domain.Producto;
import java.util.List;

/**
 *
 * @author quiro
 */
public interface ProductoService {
    public List<Producto> getProductos(boolean activos);

    public Producto getProducto(Producto producto);

    public void save(Producto producto);

    public void delete(Producto producto);

    
}
