package com.sr.sreclamo.model;

import javax.persistence.*;

@Entity
@Table(name="Marca")
public class marca {

    @Column(name = "Id_Marca")
    private Integer IdMarca;
    @Column(name = "Nombre_Marca")
    private String NombreMarca;
    
    public marca() {
    }

   
    public marca(Integer idMarca, String nombreMarca) {
        IdMarca = idMarca;
        NombreMarca = nombreMarca;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getIdMarca() {
        return IdMarca;
    }

    public void setIdMarca(Integer idMarca) {
        IdMarca = idMarca;
    }


    public String getNombreMarca() {
        return NombreMarca;
    }


    public void setNombreMarca(String nombreMarca) {
        NombreMarca = nombreMarca;
    }

   
    
}
