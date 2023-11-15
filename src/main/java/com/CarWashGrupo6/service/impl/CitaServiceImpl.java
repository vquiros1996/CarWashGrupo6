package com.CarWashGrupo6.service.impl;

import com.CarWashGrupo6.dao.CitaDao;
import com.CarWashGrupo6.domain.Cita;
import com.CarWashGrupo6.service.CitaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CitaServiceImpl implements CitaService {

    //Autowired nos sirve para traer dependencias del Dao
    //para poder usar la variable categoriaDao en os demas publics
    @Autowired
    private CitaDao citaDao;

    //METODO QUE RETORNA 1 LISTA***
    //va conectado con la clase clienteService todo lo que va ahi se hace aca con los implement abstract
    @Override
    @Transactional(readOnly = true) //uso el importe de spring en vez de jakarta en este readOnly=true
    public List<Cita> getCitas(boolean activos) {
        List<Cita> cita = citaDao.findAll(); // el findAll me permite buscar/encontrar todo
        if (activos) {
            //remover si C es true el isActivo() metodo viene de mi lombok libreria, es con IS porque es boolean
            cita.removeIf(c -> !c.isActivo()); // al texto de la C se le puede poner cualqueir otta cosa, categoria o lo que uno quiera
        }

        return cita;
    }

    //METODO QUE RETORNA UNA SOLA LISTA***
    // @Override
    public Cita getCita(Cita cita) {
        return citaDao.findById(cita.getIdCita()).orElse(null);

    }

    //METODO QUE VIENE TAMBIEN EN ClienteSERVICE insertar, modificar o eliminar si tienen el @Transactional
    @Override
    @Transactional
    public void save(Cita cita) {
        citaDao.save(cita);
    }

    //METODO QUE VIENE TAMBIEN EN clienteSERVICE
    @Override
    @Transactional
    public void delete(Cita cliente) {
        citaDao.delete(cliente);
    }

}
