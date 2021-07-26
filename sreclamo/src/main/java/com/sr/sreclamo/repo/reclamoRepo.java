package com.sr.sreclamo.repo;

import java.util.List;

import com.sr.sreclamo.model.reclamo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface reclamoRepo extends JpaRepository<reclamo, Integer>{

    @Query(value="Select * from Reclamo where (:entregaX is null or Temporada_Recepcion_Reclamo_1 like %:entregaX%)",nativeQuery=true)
    public List<reclamo> busquedaCompleja(@Param("entregaX") String entregaX);
    
}
//Temporada_Recepcion_Reclamo_1= %:entregaX%