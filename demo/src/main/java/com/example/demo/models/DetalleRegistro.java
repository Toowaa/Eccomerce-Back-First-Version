package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class DetalleRegistro {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    
    private int cantidad;

    @Column(nullable=false)
    
    private float precio;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Id_producto")
    private ProductoModel producto;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Id_Registro")
    private RegistroModel registro;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public ProductoModel getProducto() {
        return producto;
    }

    public void setProducto(ProductoModel producto) {
        this.producto = producto;
    }

    public RegistroModel getRegistro() {
        return registro;
    }

    public void setRegistro(RegistroModel registro) {
        this.registro = registro;
    }

   
       
    
}
