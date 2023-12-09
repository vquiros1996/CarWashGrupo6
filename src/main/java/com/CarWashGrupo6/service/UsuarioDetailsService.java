package com.CarWashGrupo6.service;

import com.CarWashGrupo6.domain.Usuario;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


   
//Manejo de nuestros usuarios
public interface UsuarioDetailsService {
    
    //Metodos
    public UserDetails loadUserByUsername (String username) throws UsernameNotFoundException;

    public Usuario getUsuarioPorUsername (String username) ;
    
    

}
