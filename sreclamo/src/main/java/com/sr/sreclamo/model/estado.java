package com.sr.sreclamo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class estado {
    
    private int idEstado;
    private String estado;
    public estado() {
    }
    public estado(int idEstado, String estado) {
        this.idEstado = idEstado;
        this.estado = estado;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdEstado() {
        return idEstado;
    }
    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
}
