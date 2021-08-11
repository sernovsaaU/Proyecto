package com.sr.sreclamo.repo;

import java.util.List;

import com.sr.sreclamo.model.reclamo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface reclamoRepo extends JpaRepository<reclamo, Integer>{

    @Query(value="Select * from Reclamo where (:entregaX is null or Temporada_Recepcion_Reclamo_1 like %:entregaX%) and (:entregaX2 is null or Temporada_Recepcion_Reclamo_1 like %:entregaX2%)",nativeQuery=true)
    public List<reclamo> busquedaCompleja(@Param("entregaX") String entregaX, @Param("entregaX2") String entregaX2);
    
}
//Temporada_Recepcion_Reclamo_1= %:entregaX%