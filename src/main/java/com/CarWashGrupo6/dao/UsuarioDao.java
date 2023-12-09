package com.CarWashGrupo6.dao;

import com.CarWashGrupo6.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UsuarioDao extends JpaRepository<Usuario, Long>{
    
    /*me devuelve el primer usuario que encuentra*/
   Usuario findByUsername(String username);
    
    //
}
