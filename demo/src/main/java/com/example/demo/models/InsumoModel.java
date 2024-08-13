package com.example.demo.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name="Insumos")
public class InsumoModel {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombre;

    @Column
    private float precio;

    @Column
    private int stock;
     
  /*   @ManyToAny
    Set<ProductoModel> likes;
*/


    @OneToMany(//fetch=FetchType.LAZY,
                mappedBy="insumo")
    private List<DetalleProductoModel>  detalles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public List<DetalleProductoModel> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleProductoModel> detalles) {
        this.detalles = detalles;
    }


    

    

}
