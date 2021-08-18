package com.sr.sreclamo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Usuarios")
public class Usuario {
    @Column(name = "Id_Usuario")
    private Integer IdUsuario;
    @Column(name = "Nombre_Usuario")
    private String NombreUsuario;
    @Column(name = "Apellido_Usuario")
    private String ApellidoUsuario;
    private String Clave;
    private String Rol;
    private Boolean Activo;
    @Column(name = "Credencial_Acceso")
    private String CredencialAcceso;
   
    public Usuario() {
    }

    public Usuario(Integer idUsuario, String nombreUsuario, String apellidoUsuario, String clave, String rol,
            Boolean activo, String credencialAcceso) {
        IdUsuario = idUsuario;
        NombreUsuario = nombreUsuario;
        ApellidoUsuario = apellidoUsuario;
        Clave = clave;
        Rol = rol;
        Activo = activo;
        CredencialAcceso = credencialAcceso;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        IdUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return NombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        NombreUsuario = nombreUsuario;
    }

    public String getApellidoUsuario() {
        return ApellidoUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        ApellidoUsuario = apellidoUsuario;
    }

    public String getClave() {
        return Clave;
    }

    public void setClave(String clave) {
        Clave = clave;
    }

    public String getRol() {
        return Rol;
    }

    public void setRol(String rol) {
        Rol = rol;
    }

    public Boolean getActivo() {
        return Activo;
    }

    public void setActivo(Boolean activo) {
        Activo = activo;
    }

    public String getCredencialAcceso() {
        return CredencialAcceso;
    }

    public void setCredencialAcceso(String credencialAcceso) {
        CredencialAcceso = credencialAcceso;
    }

    
}
