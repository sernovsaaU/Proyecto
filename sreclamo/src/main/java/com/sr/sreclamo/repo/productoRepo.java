package com.sr.sreclamo.repo;

import com.sr.sreclamo.model.producto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface productoRepo extends JpaRepository<producto, Integer> {

    @Query(value="Select * from Tipo_Producto where (Id_Producto = :buscaConEsteId)",nativeQuery=true)
    public producto buscarNombrePorId(@Param("buscaConEsteId") Integer buscaConEsteId);
}
