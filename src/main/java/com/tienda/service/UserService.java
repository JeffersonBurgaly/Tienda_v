package com.tienda.service;

import com.tienda.entity.Persona;
import java.nio.file.attribute.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserService implements UserDetailsService {
    
    @Autowired
    public IPersonaService personaService;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        Persona persona = this.personaService.findByNombre(username);
        Userprincipal userPrincipal = new Userprincipal(persona);
        return userPrincipal;
    }  
}
