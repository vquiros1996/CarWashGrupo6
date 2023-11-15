/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.CarWashGrupo6.dao;

import com.CarWashGrupo6.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Vivian
 */
public interface ClienteDao extends JpaRepository<Cliente, Long> {

}
