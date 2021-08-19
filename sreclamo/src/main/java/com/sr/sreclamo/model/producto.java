package com.sr.sreclamo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Tipo_Producto")
public class producto {

    @Column(name = "Id_Producto")
    private Integer IdProducto;
    @Column(name = "Nombre_Producto")
    private String NombreProducto;

    public producto() {
    }
  
    public producto(Integer idProducto, String nombreProducto) {
        IdProducto = idProducto;
        NombreProducto = nombreProducto;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getIdProducto() {
        return IdProducto;
    }

    public void setIdProducto(Integer idProducto) {
        IdProducto = idProducto;
    }

    public String getNombreProducto() {
        return NombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        NombreProducto = nombreProducto;
    }
 
    

  


  
    
}
