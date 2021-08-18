package com.sr.sreclamo.security;

import java.util.Arrays;
import java.util.Collection;
//import java.util.List;
import java.util.List;



import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.stream.Collectors;

import com.sr.sreclamo.model.Usuario;



public class MyUserDetails implements UserDetails {
    // es un model

    private String Clave;
   // private String Rol;
    private Boolean Activo;
    private String CredencialAcceso;
    private List<GrantedAuthority> authorities;
    

    public MyUserDetails() { 
    }

   
    public MyUserDetails(Usuario u) {
        this.CredencialAcceso = u.getCredencialAcceso();
        this.Clave = u.getClave();
        this.Activo = u.getActivo();


        this.authorities = Arrays.stream(u.getRol().split(","))
                    .map(SimpleGrantedAuthority::new)
                    .collect(Collectors.toList());
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }


    @Override
    public String getPassword() {
        return Clave;
    }


    @Override
    public String getUsername() {
        return CredencialAcceso;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }


    @Override
    public boolean isAccountNonLocked() {
        return true;
    }


    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }


    @Override
    public boolean isEnabled() {
        return Activo;
    }

}
