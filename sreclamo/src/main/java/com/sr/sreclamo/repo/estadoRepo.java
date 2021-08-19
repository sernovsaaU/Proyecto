package com.sr.sreclamo.repo;


import com.sr.sreclamo.model.estado;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface estadoRepo extends JpaRepository<estado, Integer>{

    @Query(value="Select * from Estado where (Id_Estado = :buscaConEsteId)",nativeQuery=true)
    public estado  buscarNombrePorId(@Param("buscaConEsteId") Integer buscaConEsteId);
    
}
