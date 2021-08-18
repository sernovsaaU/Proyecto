package com.sr.sreclamo.repo;




import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import com.sr.sreclamo.model.Usuario;



public interface usuariosRepo extends JpaRepository<Usuario, Integer> {

    public Optional<Usuario> findByCredencialAcceso(String credencialAcceso);     
}
