package com.CarWashGrupo6.service.impl;

import com.CarWashGrupo6.dao.FacturaDao;
import com.CarWashGrupo6.dao.ProductoDao;
import com.CarWashGrupo6.dao.VentaDao;
import com.CarWashGrupo6.domain.Factura;
import com.CarWashGrupo6.domain.Item;
import com.CarWashGrupo6.domain.Producto;
import com.CarWashGrupo6.domain.Usuario;
import com.CarWashGrupo6.domain.Venta;
import com.CarWashGrupo6.service.ItemService;
import static com.CarWashGrupo6.service.ItemService.listaItems;
import com.CarWashGrupo6.service.UsuarioService;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 *
 * @author quiro
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Override
    public List<Item> gets() {
        return listaItems;
    }

    //Se usa en el addCarrito... agrega un elemento
    @Override
    public void save(Item item) {
        boolean existe = false;
        for (Item i : listaItems) {
            //Busca si ya existe el producto en el carrito
            if (Objects.equals(i.getIdProducto(), item.getIdProducto())) {
                if (!existe) {//Si no está el producto en el carrito se agrega cantidad =1.            
                    item.setCantidad(1);
                    listaItems.add(item);
                }
            }
        }
    }

    //Se usa para eliminar un producto del carrito
    @Override
    public void delete(Item item) {
        var posicion = -1;
        var existe = false;
        for (Item i : listaItems) {
            ++posicion;
            if (Objects.equals(i.getIdProducto(), item.getIdProducto())) {
                existe = true;
                break;
            }
        }
        if (existe) {
            listaItems.remove(posicion);
        }
    }

    //Se obtiene la información de un producto del carrito... para modificarlo
    @Override
    public Item get(Item item) {
        for (Item i : listaItems) {
            if (Objects.equals(i.getIdProducto(), item.getIdProducto())) {
                return i;
            }
        }
        return null;
    }

    //Se usa en la página para actualizar la cantidad de productos
    @Override
    public void actualiza(Item item) {
        for (Item i : listaItems) {
            if (Objects.equals(i.getIdProducto(), item.getIdProducto())) {
                i.setCantidad(item.getCantidad());
                break;
            }
        }
    }

    @Autowired
    private UsuarioService uuarioService;

    @Autowired
    private FacturaDao facturaDao;
    @Autowired
    private VentaDao ventaDao;
    @Autowired
    private ProductoDao productoDao;

    @Override
    public void facturar() {
        System.out.println("Facturando");

        //Se obtiene el usuario autenticado
        String username;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails userDetails) {
            username = userDetails.getUsername();
        } else {
            username = principal.toString();
        }

        if (username.isBlank()) {
            return;
        }

        Usuario uuario = uuarioService.getUsuarioPorUsername(username);

        if (uuario == null) {
            return;
        }

        Factura factura = new Factura(uuario.getIdUsuario());
        factura = facturaDao.save(factura);

        double total = 0;
        for (Item i : listaItems) {
            System.out.println("Producto: " + i.getDescripcion()
                    + " Cantidad: " + i.getCantidad()
                    + " Total: " + i.getPrecio() * i.getCantidad());
            Venta venta = new Venta(factura.getIdFactura(), i.getIdProducto(), i.getPrecio(), i.getCantidad());
            ventaDao.save(venta);
            Producto producto = productoDao.getReferenceById(i.getIdProducto());
            productoDao.save(producto);
            total += i.getPrecio() * i.getCantidad();
        }
        factura.setTotal(total);
        facturaDao.save(factura);
        listaItems.clear();
    }
}