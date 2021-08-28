package com.sr.sreclamo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Exportacion")
public class exportacion {
/*
    `Id_exportacion` INT NOT NULL AUTO_INCREMENT,
  `Kilos` INT NOT NULL,
  `Temporada_Exportacion_1` DATE NOT NULL,
  `Temporada_Exportacion_2` DATE NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `Fecha_Exportacion` DATE NOT NULL,
  `Tipo_Producto_Id_Producto` INT NOT NULL,
  `Marca_Id_Marca` INT NOT NULL,
  `Tipo_Fruta_Id_Tipo_Fruta` INT NOT NULL,
  `Cliente_Id_Cliente` INT NOT NULL,
    */
    @Column(name="Id_exportacion")
    private Integer idExportacion;
    @Column(name="Kilos")
    private Integer Kilos;
    @Column(name="Temporada_Exportacion_1")
    private Date Temporada_Exportacion_1;
    @Column(name="Temporada_Exportacion_2")
    private Date Temporada_Exportacion_2;
    @Column(name="Fecha_Exportacion")
    private Date Fecha_Exportacion;
    @Column(name="Tipo_Producto_Id_Producto")
    private Integer Tipo_Producto_Id_Producto;
    @Column(name="Marca_Id_Marca")
    private Integer Marca_Id_Marca;
    @Column(name="Tipo_Fruta_Id_Tipo_Fruta")
    private Integer Tipo_Fruta_Id_Tipo_Fruta;
    @Column(name="Cliente_Id_Cliente")
    private Integer Cliente_Id_Cliente;
    
    public exportacion() {
    }

    public exportacion(Integer idExportacion, Integer kilos, Date temporada_Exportacion_1, Date temporada_Exportacion_2,
            Date fecha_Exportacion, Integer tipo_Producto_Id_Producto, Integer marca_Id_Marca,
            Integer tipo_Fruta_Id_Tipo_Fruta, Integer cliente_Id_Cliente) {
        this.idExportacion = idExportacion;
        Kilos = kilos;
        Temporada_Exportacion_1 = temporada_Exportacion_1;
        Temporada_Exportacion_2 = temporada_Exportacion_2;
        Fecha_Exportacion = fecha_Exportacion;
        Tipo_Producto_Id_Producto = tipo_Producto_Id_Producto;
        Marca_Id_Marca = marca_Id_Marca;
        Tipo_Fruta_Id_Tipo_Fruta = tipo_Fruta_Id_Tipo_Fruta;
        Cliente_Id_Cliente = cliente_Id_Cliente;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getIdExportacion() {
        return idExportacion;
    }

    public void setIdExportacion(Integer idExportacion) {
        this.idExportacion = idExportacion;
    }

    public Integer getKilos() {
        return Kilos;
    }

    public void setKilos(Integer kilos) {
        Kilos = kilos;
    }

    public Date getTemporada_Exportacion_1() {
        return Temporada_Exportacion_1;
    }

    public void setTemporada_Exportacion_1(Date temporada_Exportacion_1) {
        Temporada_Exportacion_1 = temporada_Exportacion_1;
    }

    public Date getTemporada_Exportacion_2() {
        return Temporada_Exportacion_2;
    }

    public void setTemporada_Exportacion_2(Date temporada_Exportacion_2) {
        Temporada_Exportacion_2 = temporada_Exportacion_2;
    }

    public Date getFecha_Exportacion() {
        return Fecha_Exportacion;
    }

    public void setFecha_Exportacion(Date fecha_Exportacion) {
        Fecha_Exportacion = fecha_Exportacion;
    }

    public Integer getTipo_Producto_Id_Producto() {
        return Tipo_Producto_Id_Producto;
    }

    public void setTipo_Producto_Id_Producto(Integer tipo_Producto_Id_Producto) {
        Tipo_Producto_Id_Producto = tipo_Producto_Id_Producto;
    }

    public Integer getMarca_Id_Marca() {
        return Marca_Id_Marca;
    }

    public void setMarca_Id_Marca(Integer marca_Id_Marca) {
        Marca_Id_Marca = marca_Id_Marca;
    }

    public Integer getTipo_Fruta_Id_Tipo_Fruta() {
        return Tipo_Fruta_Id_Tipo_Fruta;
    }

    public void setTipo_Fruta_Id_Tipo_Fruta(Integer tipo_Fruta_Id_Tipo_Fruta) {
        Tipo_Fruta_Id_Tipo_Fruta = tipo_Fruta_Id_Tipo_Fruta;
    }

    public Integer getCliente_Id_Cliente() {
        return Cliente_Id_Cliente;
    }

    public void setCliente_Id_Cliente(Integer cliente_Id_Cliente) {
        Cliente_Id_Cliente = cliente_Id_Cliente;
    }
    
    
    
}
