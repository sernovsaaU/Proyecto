package com.sr.sreclamo.repo;

//import java.util.List;

import com.sr.sreclamo.model.tipo_fruta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface frutaRepo extends JpaRepository<tipo_fruta,Integer>{

    @Query(value="Select * from tipo_fruta where (Id_Tipo_Fruta = :buscaConEsteId)",nativeQuery=true)
    public tipo_fruta  buscarNombrePorId(@Param("buscaConEsteId") Integer buscaConEsteId);
}
