package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Cliente")
public class ClienteModel {
    @Id
    private Long dni;
    
    @Column(unique = true, length = 100, nullable = false)
    private String usuario;
    @Column(nullable = false)
    private String contraseña;
    @Column
    private String nombre;

    @Column
    private String apellido;

    @Column
    private int telefono;

    @OneToOne(//fetch=FetchType.LAZY,
    optional=false)
    @JoinColumn(name="id_direccion")
    private DireccionCModel direccion;

   
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public DireccionCModel getDireccion() {
        return direccion;
    }

    public void setDireccion(DireccionCModel direccion) {
        this.direccion = direccion;
    }

    public Long getDni() {
        return dni;
    }

    public void setDni(Long dni) {
        this.dni = dni;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    





}
