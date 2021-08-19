package com.sr.sreclamo.repo;

import com.sr.sreclamo.model.cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface clienteRepo extends JpaRepository<cliente, Integer> {

    @Query(value="Select * from Cliente where (Id_Cliente = :buscaConEsteId)",nativeQuery=true)
    public cliente  buscarNombrePorId(@Param("buscaConEsteId") Integer buscaConEsteId);
    
}
