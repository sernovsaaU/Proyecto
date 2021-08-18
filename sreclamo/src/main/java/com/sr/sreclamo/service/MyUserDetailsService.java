package com.sr.sreclamo.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.sr.sreclamo.model.Usuario;
import com.sr.sreclamo.repo.usuariosRepo;
import com.sr.sreclamo.security.MyUserDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService{

    @Autowired
    usuariosRepo uRepo;

    @Override
    public UserDetails loadUserByUsername(String CredencialAcceso) throws UsernameNotFoundException {
        Optional <Usuario> usuarioIngresado= uRepo.findByCredencialAcceso(CredencialAcceso);
        usuarioIngresado.orElseThrow(()-> new UsernameNotFoundException("Usuario no registrado: " + CredencialAcceso )); 

        return usuarioIngresado.map(MyUserDetails::new).get();
    }
    
    
}
