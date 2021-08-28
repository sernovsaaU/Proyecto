package com.sr.sreclamo.repo;


import java.util.List;



import com.sr.sreclamo.model.reclamo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface reclamoRepo extends JpaRepository<reclamo, Integer>{

    /*
    @Query(value="Select * from Reclamo where (:entregaX is null or Temporada_Recepcion_Reclamo_1 like %:entregaX%) and (:entregaX2 is null or Temporada_Recepcion_Reclamo_1 like %:entregaX2%)",nativeQuery=true)
    public List<reclamo> busquedaCompleja(@Param("entregaX") String entregaX, @Param("entregaX2") String entregaX2);
     */

    @Query(value="Select * from Reclamo where (:entregaX is null or Temporada_Recepcion_Reclamo_1 like %:entregaX%) and (:entregaX2 is null or Temporada_Recepcion_Reclamo_1 like %:entregaX2%)",nativeQuery=true)
    public List<reclamo> busquedaCompleja(@Param("entregaX") Integer entregaX, @Param("entregaX2") Integer entregaX2);

    @Query(value="Select * from Reclamo where (:N is null or Numero_Reclamo like :N) and (:CIR is null or Codigo_Interno_Reclamo like :CIR) and (:FRC is null or Fecha_Recepcion_Reclamo like %:FRC%) and (:TRR1 is null or Temporada_Recepcion_Reclamo_1 like :TRR1) and (:TRR2 is null or Temporada_Recepcion_Reclamo_2 like :TRR2) and (:FRR is null or Fecha_Respuesta_Reclamo like %:FRR%) and (:TPR1 is null or Temporada_Proceso_Reclamo_1 like :TPR1) and (:TPR2 is null or Temporada_Proceso_Reclamo_2 like :TPR2) and(:EI is null or Estado_Id_estado like :EI) and (:I is null or Investigacion_Id_Investigacion like :I) and (:TPI is null or Tipo_Producto_Id_Producto like :TPI) and (:MI is null or Marca_Id_Marca like :MI) and (:TFI is null or Tipo_Fruta_Id_Tipo_Fruta like :TFI) and (:CI is null or Cliente_Id_Cliente like :CI) and (:STCRI is null or Sub_Tipo_CR_Id_Sub_Tipo_CR like :STCRI)",nativeQuery=true)
    public List<reclamo> consultaMParam(@Param("N") Integer N,@Param("CIR") Integer CIR,@Param("FRC") String FRC,@Param("TRR1") Integer TRR1,@Param("TRR2") Integer TRR2,@Param("FRR") String FRR,@Param("TPR1") Integer TPR1,@Param("TPR2") Integer TPR2,@Param("EI") Integer EI,@Param("I") Integer I,@Param("TPI") Integer TPI,@Param("MI") Integer MI,@Param("TFI") Integer TFI,@Param("CI") Integer CI,@Param("STCRI") Integer STCRI);

    @Transactional
    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query(value="UPDATE reclamo set Detalle_Reclamo = :DR, Fecha_Recepcion_Reclamo = :FRC, Temporada_Recepcion_Reclamo_1 = :TRR1, Temporada_Recepcion_Reclamo_2 = :TRR2 , Fecha_Respuesta_Reclamo = :FRR , Temporada_Proceso_Reclamo_1 = :TPR1 , Temporada_Proceso_Reclamo_2 = :TPR2 , Estado_Id_estado = :EI , Investigacion_Id_Investigacion = :I , Tipo_Producto_Id_Producto = :TPI , Marca_Id_Marca = :MI , Tipo_Fruta_Id_Tipo_Fruta = :TFI , Cliente_Id_Cliente = :CI , Sub_Tipo_CR_Id_Sub_Tipo_CR = :STCRI where Numero_Reclamo = :N and Codigo_Interno_Reclamo = :CIR",nativeQuery=true)
    public void update(@Param("DR") String DR,@Param("FRC") String FRC,@Param("TRR1") Integer TRR1,@Param("TRR2") Integer TRR2,@Param("FRR") String FRR,@Param("TPR1") Integer TPR1,@Param("TPR2") Integer TPR2,@Param("EI") Integer EI,@Param("I") Integer I,@Param("TPI") Integer TPI,@Param("MI") Integer MI,@Param("TFI") Integer TFI,@Param("CI") Integer CI,@Param("STCRI") Integer STCRI,@Param("N") Integer N, @Param("CIR") Integer CIR);
    
    //"date", sqlDate

    //CIR,
/*
 UPDATE table_name SET field1 = new-value1, field2 = new-value2
    [WHERE Clause]
     (:FRC is null or Fecha_Recepcion_Reclamo like %:FRC%)

    @Query(value="Select * from Reclamo where (:entregaX is null or Temporada_Recepcion_Reclamo_1 like %:entregaX%) and (:entregaX2 is null or Temporada_Recepcion_Reclamo_1 like %:entregaX2%)",nativeQuery=true)
    public List<reclamo> busquedaConRecla(@Param("CIR") String CIR, @Param("entregaX2") String entregaX2,@Param("entregaX") String entregaX, @Param("entregaX2") String entregaX2);
    

    (:CIR is null or Codigo_Interno_Reclamo like %:CIR%) and (:DR is null or Detalle_Reclamo like %:DR%) and 
    (:FRC is null or Fecha_Recepcion_Reclamo like %:FRC%) and (:TRR1 is null or Temporada_Recepcion_Reclamo_1 like %:TRR1%) and
    (:TRR2 is null or Temporada_Recepcion_Reclamo_2 like %:TRR2%) and (:FRR is null or Fecha_Respuesta_Reclamo like %:FRR%) and
    (:TPR1 is null or Temporada_Proceso_Reclamo_1 like %:TPR1%) and (:TPR2 is null or Temporada_Proceso_Reclamo_2 like %:TPR2%) and
    (:EI is null or Estado_Id_estado like %:EI%) and (:I is null or Investigacion_Id_Investigacion like %:I%) and
    (:TPI is null or Tipo_Producto_Id_Producto like %:TPI%) and (:MI is null or Marca_Id_Marca like %:MI%) and 
    (:TFI is null or Tipo_Fruta_Id_Tipo_Fruta like %:TFI%) and (:CI is null or Cliente_Id_Cliente like %:CI%) and
    (:STCRI is null or Sub_Tipo_CR_Id_Sub_Tipo_CR like %:STCRI%)

            numero de reclamo           n
        Codigo_Interno_Reclamo,         CIR             (:CIR is null or Codigo_Interno_Reclamo like %:CIR%)
str      Detalle_Reclamo,                DR              (:DR is null or Detalle_Reclamo like %:DR%)
date    Fecha_Recepcion_Reclamo,        FRC             (:FRC is null or Fecha_Recepcion_Reclamo like %:FRC%)
        Temporada_Recepcion_Reclamo_1,  TRR1            (:TRR1 is null or Temporada_Recepcion_Reclamo_1 like %:TRR1%)
        Temporada_Recepcion_Reclamo_2,  TRR2            (:TRR2 is null or Temporada_Recepcion_Reclamo_2 like %:TRR2%)            
date    Fecha_Respuesta_Reclamo,        FRR             (:FRR is null or Fecha_Respuesta_Reclamo like %:FRR%)
        Temporada_Proceso_Reclamo_1,    TPR1            (:TPR1 is null or Temporada_Proceso_Reclamo_1 like %:TPR1%)
        Temporada_Proceso_Reclamo_2,    TPR2            (:TPR2 is null or Temporada_Proceso_Reclamo_2 like %:TPR2%)
        Estado_Id_estado,               EI              (:EI is null or Estado_Id_estado like %:EI%)
        Investigacion_Id_Investigacion, I               (:I is null or Investigacion_Id_Investigacion like %:I%)
        Tipo_Producto_Id_Producto,      TPI             (:TPI is null or Tipo_Producto_Id_Producto like %:TPI%)
        Marca_Id_Marca,                 MI              (:MI is null or Marca_Id_Marca like %:MI%)
        Tipo_Fruta_Id_Tipo_Fruta,       TFI             (:TFI is null or Tipo_Fruta_Id_Tipo_Fruta like %:TFI%)
        Cliente_Id_Cliente,             CI              (:CI is null or Cliente_Id_Cliente like %:CI%)
        Sub_Tipo_CR_Id_Sub_Tipo_CR      STCRI           (:STCRI is null or Sub_Tipo_CR_Id_Sub_Tipo_CR like %:STCRI%)

    (:N is null or Numero_Reclamo like :N)
    (:CIR is null or Codigo_Interno_Reclamo like :CIR) and (:DR is null or Detalle_Reclamo like %:DR%) and 
    (:FRC is null or Fecha_Recepcion_Reclamo like :FRC) and (:TRR1 is null or Temporada_Recepcion_Reclamo_1 like :TRR1) and
    (:TRR2 is null or Temporada_Recepcion_Reclamo_2 like :TRR2) and (:FRR is null or Fecha_Respuesta_Reclamo like :FRR) and
    (:TPR1 is null or Temporada_Proceso_Reclamo_1 like :TPR1) and (:TPR2 is null or Temporada_Proceso_Reclamo_2 like :TPR2) and
    (:EI is null or Estado_Id_estado like :EI) and (:I is null or Investigacion_Id_Investigacion like :I) and
    (:TPI is null or Tipo_Producto_Id_Producto like :TPI) and (:MI is null or Marca_Id_Marca like :MI) and 
    (:TFI is null or Tipo_Fruta_Id_Tipo_Fruta like :TFI) and (:CI is null or Cliente_Id_Cliente like :CI) and
    (:STCRI is null or Sub_Tipo_CR_Id_Sub_Tipo_CR like :STCRI)
*/
}
//Temporada_Recepcion_Reclamo_1= %:entregaX%