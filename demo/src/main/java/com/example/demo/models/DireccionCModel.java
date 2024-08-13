package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class DireccionCModel {
    @Id
    private Long id;

    @Column
    private String calle;

    @Column
    private String numero_exterior;

    @Column
    private String ciudad;

    @Column
    private String codigopostal;

    @Column
    private String tipodireccion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero_exterior() {
        return numero_exterior;
    }

    public void setNumero_exterior(String numero_exterior) {
        this.numero_exterior = numero_exterior;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCodigopostal() {
        return codigopostal;
    }

    public void setCodigopostal(String codigopostal) {
        this.codigopostal = codigopostal;
    }

    public String getTipodireccion() {
        return tipodireccion;
    }

    public void setTipodireccion(String tipodireccion) {
        this.tipodireccion = tipodireccion;
    }

    

}
