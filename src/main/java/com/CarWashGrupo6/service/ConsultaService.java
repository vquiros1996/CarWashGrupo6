/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.CarWashGrupo6.service;

import com.CarWashGrupo6.domain.Consulta;
import java.util.List;

/**
 *
 * @author quiro
 */
public interface ConsultaService {
     public List<Consulta> getConsultas(boolean activos);

    public List<Consulta> getMostrar(Consulta consulta);
    
    
    public Consulta getCategoria(Consulta consulta);

    
    public void save(Consulta consulta);

    public void delete(Consulta consulta);

    public Consulta getConsulta(Consulta consulta);
}

