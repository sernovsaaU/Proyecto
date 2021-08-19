package com.sr.sreclamo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cliente")
public class cliente {
    @Column(name = "Id_Cliente")
    private Integer IdCliente;
    @Column(name = "Nombre_Cliente")
    private String NombreCliente;
    
    public cliente() {
    }

    public cliente(Integer idCliente, String nombreCliente) {
        IdCliente = idCliente;
        NombreCliente = nombreCliente;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(Integer idCliente) {
        IdCliente = idCliente;
    }

    public String getNombreCliente() {
        return NombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        NombreCliente = nombreCliente;
    }
  
    
}
