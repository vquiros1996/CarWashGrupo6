package com.CarWashGrupo6.service;

import com.CarWashGrupo6.domain.Cita;
import java.util.List;

public interface CitaService {
    //valor de retorno una lista de cliente
    //un solo objeto singular, clientes para el objeto
    //parametro a recibir un booleano de activos , ya sea para traer tdas
    //o algunas de las clientes
    //el activos nos sirve para traer todas las clientes que esten activas

    public List<Cita> getCitas(boolean activos);

    //RETORNA UNA Cliente POR ID
    public Cita getCita(Cita cita);

    //SE INSERTA UN NUEVO REGISTRO SI EL ID DE LA Cliente ESTA VACIO
    //SE ACTUALIZA EL REGISTRO SI EL ID DE LA cliente NO ESTA VACIO
    public void save(Cita cita);

    public void delete(Cita cita);
}
