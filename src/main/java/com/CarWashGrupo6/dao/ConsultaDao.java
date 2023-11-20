/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.CarWashGrupo6.dao;

import com.CarWashGrupo6.domain.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author quiro
 */
public interface ConsultaDao extends JpaRepository<Consulta, Long> {
    
}

