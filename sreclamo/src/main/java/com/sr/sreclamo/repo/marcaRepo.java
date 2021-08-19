package com.sr.sreclamo.repo;

import com.sr.sreclamo.model.marca;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface marcaRepo extends JpaRepository<marca, Integer> {

    @Query(value="Select * from Marca where (Id_Marca = :buscaConEsteId)",nativeQuery=true)
    public marca buscarNombrePorId(@Param("buscaConEsteId") Integer buscaConEsteId);  
    
}
