/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.CarWashGrupo6.service;

import com.CarWashGrupo6.domain.Cliente;
import java.util.List;

/**
 *
 * @author Vivian
 */
//sera como el MENU de nosotros, nos permite conectarse
//con las otras cetegorias
//vamos a tener metodos de salvar/ eliminar/ buscar categorias
//como un "CRUD"
public interface ClienteService {

    //valor de retorno una lista de cliente
    //un solo objeto singular, clientes para el objeto
    //parametro a recibir un booleano de activos , ya sea para traer tdas
    //o algunas de las clientes
    //el activos nos sirve para traer todas las clientes que esten activas
    public List<Cliente> getClientes(boolean activos);

    public List<Cliente> getMostrar(Cliente clinete);
    
    //RETORNA UNA Cliente POR ID
    public Cliente getCategoria(Cliente cliente);

    //SE INSERTA UN NUEVO REGISTRO SI EL ID DE LA Cliente ESTA VACIO
    //SE ACTUALIZA EL REGISTRO SI EL ID DE LA cliente NO ESTA VACIO
    public void save(Cliente cliente);

    public void delete(Cliente cliente);

    public Cliente getCliente(Cliente cliente);

}
