package com.sr.sreclamo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Estado")
public class estado {
   
    @Column(name = "Id_Estado")
    private Integer IdEstado;
    private String Estado;
    
    public estado() {
    }

    public estado(Integer idEstado, String estado) {
        IdEstado = idEstado;
        Estado = estado;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getIdEstado() {
        return IdEstado;
    }

    public void setIdEstado(Integer idEstado) {
        IdEstado = idEstado;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    
}
