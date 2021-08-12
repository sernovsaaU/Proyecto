package com.sr.sreclamo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class tipo_fruta {
    private String Nombre_Tipo_Fruta;
    private Integer Id_Tipo_Fruta;
    public tipo_fruta() {
    }
    public tipo_fruta(String nombre_Tipo_Fruta, Integer id_Tipo_Fruta) {
        Nombre_Tipo_Fruta = nombre_Tipo_Fruta;
        Id_Tipo_Fruta = id_Tipo_Fruta;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public String getNombre_Tipo_Fruta() {
        return Nombre_Tipo_Fruta;
    }
    public void setNombre_Tipo_Fruta(String nombre_Tipo_Fruta) {
        Nombre_Tipo_Fruta = nombre_Tipo_Fruta;
    }
    public Integer getId_Tipo_Fruta() {
        return Id_Tipo_Fruta;
    }
    public void setId_Tipo_Fruta(Integer id_Tipo_Fruta) {
        Id_Tipo_Fruta = id_Tipo_Fruta;
    }
}
