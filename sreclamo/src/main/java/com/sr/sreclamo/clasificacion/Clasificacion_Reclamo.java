package com.sr.sreclamo.clasificacion;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Clasificacion_Reclamo {
    
    private Integer Id_Clasificacion_Reclamo;
    private String Nombre_Clasificacion_Reclamo ;
    public Clasificacion_Reclamo() {
    }
    public Clasificacion_Reclamo(String nombre_Clasificacion_Reclamo) {
        Nombre_Clasificacion_Reclamo = nombre_Clasificacion_Reclamo;
    }
    public Clasificacion_Reclamo(int id_Clasificacion_Reclamo, String nombre_Clasificacion_Reclamo) {
        Id_Clasificacion_Reclamo = id_Clasificacion_Reclamo;
        Nombre_Clasificacion_Reclamo = nombre_Clasificacion_Reclamo;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId_Clasificacion_Reclamo() {
        return Id_Clasificacion_Reclamo;
    }
    public void setId_Clasificacion_Reclamo(Integer id_Clasificacion_Reclamo) {
        Id_Clasificacion_Reclamo = id_Clasificacion_Reclamo;
    }
    public String getNombre_Clasificacion_Reclamo() {
        return Nombre_Clasificacion_Reclamo;
    }
    public void setNombre_Clasificacion_Reclamo(String nombre_Clasificacion_Reclamo) {
        Nombre_Clasificacion_Reclamo = nombre_Clasificacion_Reclamo;
    }  
}