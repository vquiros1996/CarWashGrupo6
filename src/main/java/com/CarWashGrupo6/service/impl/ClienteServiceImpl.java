/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.CarWashGrupo6.service.impl;

import com.CarWashGrupo6.dao.ClienteDao;
import com.CarWashGrupo6.domain.Cliente;
import com.CarWashGrupo6.service.ClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Vivian
 */
@Service
public class ClienteServiceImpl implements ClienteService {

    //Autowired nos sirve para traer dependencias del Dao
    //para poder usar la variable categoriaDao en os demas publics
    @Autowired
    private ClienteDao clienteDao;

    //METODO QUE RETORNA 1 LISTA***
    //va conectado con la clase clienteService todo lo que va ahi se hace aca con los implement abstract
    @Override
    @Transactional(readOnly = true) //uso el importe de spring en vez de jakarta en este readOnly=true
    public List<Cliente> getClientes(boolean activos) {
        List<Cliente> cliente = clienteDao.findAll(); // el findAll me permite buscar/encontrar todo
        if (activos) {
            //remover si C es true el isActivo() metodo viene de mi lombok libreria, es con IS porque es boolean
            cliente.removeIf(c -> !c.isActivo()); // al texto de la C se le puede poner cualqueir otta cosa, categoria o lo que uno quiera
        }

        return cliente;
    }

    //METODO QUE RETORNA UNA SOLA LISTA***
    // @Override
    public Cliente getCliente(Cliente cliente) {

        return clienteDao.findById(cliente.getIdCliente()).orElse(null);

    }

    //METODO QUE VIENE TAMBIEN EN ClienteSERVICE insertar, modificar o eliminar si tienen el @Transactional
    @Override
    @Transactional
    public void save(Cliente cliente) {
        clienteDao.save(cliente);
    }

    //METODO QUE VIENE TAMBIEN EN clienteSERVICE
    @Override
    @Transactional
    public void delete(Cliente cliente) {
        clienteDao.delete(cliente);
    }

    @Override
    public Cliente getCategoria(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Cliente> getMostrar(Cliente clinete) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
