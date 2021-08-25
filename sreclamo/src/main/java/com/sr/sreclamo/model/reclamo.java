package com.sr.sreclamo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Reclamo")
public class reclamo {
    /*Numero_Reclamo` INT NOT NULL AUTO_INCREMENT,
  `Codigo_Interno_Reclamo` INT NOT NULL,
  `Detalle_Reclamo` VARCHAR(255) NOT NULL,
  `Fecha_Recepcion_Reclamo` DATE NOT NULL,
  `Temporada_Recepcion_Reclamo_1` INT NOT NULL,
  `Temporada_Recepcion_Reclamo_2` INT NOT NULL,
  `Fecha_Respuesta_Reclamo` DATE NOT NULL,
  `Temporada_Proceso_Reclamo_1` INT NOT NULL,
  `Temporada_Proceso_Reclamo_2` INT NOT NULL,
  `Estado_Id_estado` INT NOT NULL,
  `Investigacion_Id_Investigacion` INT NULL,
  `Tipo_Producto_Id_Producto` INT NOT NULL,
  `Marca_Id_Marca` INT NOT NULL,
  `Tipo_Fruta_Id_Tipo_Fruta` INT NOT NULL,
  `Cliente_Id_Cliente` INT NOT NULL,
  `Sub_Tipo_CR_Id_Sub_Tipo_CR` INT NOT NULL,*/
  @Column(name = "Numero_Reclamo")
    private Integer Numero_Reclamo;
    @Column(name = "Codigo_Interno_Reclamo")
    private Integer Codigo_Interno_Reclamo;
    @Column(name = "Detalle_Reclamo")
    private String Detalle_Reclamo;
    @Column(name = "Fecha_Recepcion_Reclamo")
    @DateTimeFormat(pattern = "yyyy-MM-d")
    private Date Fecha_Recepcion_Reclamo;
    @Column(name = "Temporada_Recepcion_Reclamo_1")
    private Integer Temporada_Recepcion_Reclamo_1;
    @Column(name = "Temporada_Recepcion_Reclamo_2")
    private Integer Temporada_Recepcion_Reclamo_2;
    @Column(name = "Fecha_Respuesta_Reclamo")
    @DateTimeFormat(pattern = "yyyy-MM-d")
    private Date Fecha_Respuesta_Reclamo;
    @Column(name = "Temporada_Proceso_Reclamo_1")
    private Integer Temporada_Proceso_Reclamo_1;
    @Column(name = "Temporada_Proceso_Reclamo_2")
    private Integer Temporada_Proceso_Reclamo_2;
    @Column(name = "Estado_Id_estado")
    private Integer Estado_Id_estado;
    @Column(name = "Investigacion_Id_Investigacion")
    private Integer Investigacion_Id_Investigacion;
    @Column(name = "Tipo_Producto_Id_Producto")
    private Integer Tipo_Producto_Id_Producto;
    @Column(name = "Marca_Id_Marca")
    private Integer Marca_Id_Marca;
    @Column(name = "Tipo_Fruta_Id_Tipo_Fruta")
    private Integer Tipo_Fruta_Id_Tipo_Fruta;
    @Column(name = "Cliente_Id_Cliente",nullable = false)
    private Integer ClienteIdCliente;
    @Column(name = "Sub_Tipo_CR_Id_Sub_Tipo_CR")
    private Integer Sub_Tipo_CR_Id_Sub_Tipo_CR;
    
    public reclamo() {
    }

    public reclamo(Integer numero_Reclamo, Integer codigo_Interno_Reclamo, String detalle_Reclamo,
            Date fecha_Recepcion_Reclamo, Integer temporada_Recepcion_Reclamo_1, Integer temporada_Recepcion_Reclamo_2,
            Date fecha_Respuesta_Reclamo, Integer temporada_Proceso_Reclamo_1, Integer temporada_Proceso_Reclamo_2,
            Integer estado_Id_estado, Integer investigacion_Id_Investigacion, Integer tipo_Producto_Id_Producto,
            Integer marca_Id_Marca, Integer tipo_Fruta_Id_Tipo_Fruta, Integer clienteIdCliente,
            Integer sub_Tipo_CR_Id_Sub_Tipo_CR) {
        Numero_Reclamo = numero_Reclamo;
        Codigo_Interno_Reclamo = codigo_Interno_Reclamo;
        Detalle_Reclamo = detalle_Reclamo;
        Fecha_Recepcion_Reclamo = fecha_Recepcion_Reclamo;
        Temporada_Recepcion_Reclamo_1 = temporada_Recepcion_Reclamo_1;
        Temporada_Recepcion_Reclamo_2 = temporada_Recepcion_Reclamo_2;
        Fecha_Respuesta_Reclamo = fecha_Respuesta_Reclamo;
        Temporada_Proceso_Reclamo_1 = temporada_Proceso_Reclamo_1;
        Temporada_Proceso_Reclamo_2 = temporada_Proceso_Reclamo_2;
        Estado_Id_estado = estado_Id_estado;
        Investigacion_Id_Investigacion = investigacion_Id_Investigacion;
        Tipo_Producto_Id_Producto = tipo_Producto_Id_Producto;
        Marca_Id_Marca = marca_Id_Marca;
        Tipo_Fruta_Id_Tipo_Fruta = tipo_Fruta_Id_Tipo_Fruta;
        ClienteIdCliente = clienteIdCliente;
        Sub_Tipo_CR_Id_Sub_Tipo_CR = sub_Tipo_CR_Id_Sub_Tipo_CR;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getNumero_Reclamo() {
        return Numero_Reclamo;
    }

    public void setNumero_Reclamo(Integer numero_Reclamo) {
        Numero_Reclamo = numero_Reclamo;
    }

    public Integer getCodigo_Interno_Reclamo() {
        return Codigo_Interno_Reclamo;
    }

    public void setCodigo_Interno_Reclamo(Integer codigo_Interno_Reclamo) {
        Codigo_Interno_Reclamo = codigo_Interno_Reclamo;
    }

    public String getDetalle_Reclamo() {
        return Detalle_Reclamo;
    }

    public void setDetalle_Reclamo(String detalle_Reclamo) {
        Detalle_Reclamo = detalle_Reclamo;
    }

    public Date getFecha_Recepcion_Reclamo() {
        return Fecha_Recepcion_Reclamo;
    }

    public void setFecha_Recepcion_Reclamo(Date fecha_Recepcion_Reclamo) {
        Fecha_Recepcion_Reclamo = fecha_Recepcion_Reclamo;
    }

    public Integer getTemporada_Recepcion_Reclamo_1() {
        return Temporada_Recepcion_Reclamo_1;
    }

    public void setTemporada_Recepcion_Reclamo_1(Integer temporada_Recepcion_Reclamo_1) {
        Temporada_Recepcion_Reclamo_1 = temporada_Recepcion_Reclamo_1;
    }

    public Integer getTemporada_Recepcion_Reclamo_2() {
        return Temporada_Recepcion_Reclamo_2;
    }

    public void setTemporada_Recepcion_Reclamo_2(Integer temporada_Recepcion_Reclamo_2) {
        Temporada_Recepcion_Reclamo_2 = temporada_Recepcion_Reclamo_2;
    }

    public Date getFecha_Respuesta_Reclamo() {
        return Fecha_Respuesta_Reclamo;
    }

    public void setFecha_Respuesta_Reclamo(Date fecha_Respuesta_Reclamo) {
        Fecha_Respuesta_Reclamo = fecha_Respuesta_Reclamo;
    }

    public Integer getTemporada_Proceso_Reclamo_1() {
        return Temporada_Proceso_Reclamo_1;
    }

    public void setTemporada_Proceso_Reclamo_1(Integer temporada_Proceso_Reclamo_1) {
        Temporada_Proceso_Reclamo_1 = temporada_Proceso_Reclamo_1;
    }

    public Integer getTemporada_Proceso_Reclamo_2() {
        return Temporada_Proceso_Reclamo_2;
    }

    public void setTemporada_Proceso_Reclamo_2(Integer temporada_Proceso_Reclamo_2) {
        Temporada_Proceso_Reclamo_2 = temporada_Proceso_Reclamo_2;
    }

    public Integer getEstado_Id_estado() {
        return Estado_Id_estado;
    }

    public void setEstado_Id_estado(Integer estado_Id_estado) {
        Estado_Id_estado = estado_Id_estado;
    }

    public Integer getInvestigacion_Id_Investigacion() {
        return Investigacion_Id_Investigacion;
    }

    public void setInvestigacion_Id_Investigacion(Integer investigacion_Id_Investigacion) {
        Investigacion_Id_Investigacion = investigacion_Id_Investigacion;
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

    public Integer getClienteIdCliente() {
        return ClienteIdCliente;
    }

    public void setClienteIdCliente(Integer clienteIdCliente) {
        ClienteIdCliente = clienteIdCliente;
    }

    public Integer getSub_Tipo_CR_Id_Sub_Tipo_CR() {
        return Sub_Tipo_CR_Id_Sub_Tipo_CR;
    }

    public void setSub_Tipo_CR_Id_Sub_Tipo_CR(Integer sub_Tipo_CR_Id_Sub_Tipo_CR) {
        Sub_Tipo_CR_Id_Sub_Tipo_CR = sub_Tipo_CR_Id_Sub_Tipo_CR;
    }


}

