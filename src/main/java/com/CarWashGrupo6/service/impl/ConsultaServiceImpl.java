package com.CarWashGrupo6.service.impl;

import com.CarWashGrupo6.dao.ConsultaDao;
import com.CarWashGrupo6.domain.Consulta;
import com.CarWashGrupo6.service.ConsultaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author quiro
 */
@Service
public class ConsultaServiceImpl implements ConsultaService {

    //Autowired nos sirve para traer dependencias del Dao
    //para poder usar la variable categoriaDao en os demas publics
    @Autowired
    private ConsultaDao consultaDao;

    //METODO QUE RETORNA 1 LISTA***
    //va conectado con la clase ConsultaService todo lo que va ahi se hace aca con los implement abstract
    //@Override
    @Transactional(readOnly = true) //uso el importe de spring en vez de jakarta en este readOnly=true
    public List<Consulta> getConsultas(boolean activos) {
        List<Consulta> consulta = consultaDao.findAll(); // el findAll me permite buscar/encontrar todo
        if (activos) {
            //remover si C es true el isActivo() metodo viene de mi lombok libreria, es con IS porque es boolean
                
        }

        return consulta;
    }

    //METODO QUE RETORNA UNA SOLA LISTA***
    
    //@Override
    public Consulta getConsulta(Consulta consulta) {

        return consultaDao.findById(consulta.getIdConsulta()).orElse(null);

    }

    //METODO QUE VIENE TAMBIEN EN ClienteSERVICE insertar, modificar o eliminar si tienen el @Transactional
    @Override
    @Transactional
    public void save(Consulta consulta) {
        consultaDao.save(consulta);
    }

    //METODO QUE VIENE TAMBIEN EN ConsultaSERVICE
    @Override
    @Transactional
    public void delete(Consulta consulta) {
        consultaDao.delete(consulta);
    }

    @Override
    public List<Consulta> getMostrar(Consulta consulta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Consulta getCategoria(Consulta consulta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}