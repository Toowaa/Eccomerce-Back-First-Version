package com.example.demo.Services;

import com.example.demo.models.CategoriaModel;

public class ProductoDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    private int stock;
    private double precio;
    private CategoriaModel categoriaModel;

    public ProductoDTO(CategoriaModel categoriaModel, String descripcion, Long id, String nombre, double precio, int stock) {
        this.categoriaModel = categoriaModel;
        this.descripcion = descripcion;
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public ProductoDTO() {
    }

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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public CategoriaModel getCategoriaModel() {
        return categoriaModel;
    }

    public void setCategoriaModel(CategoriaModel categoriaModel) {
        this.categoriaModel = categoriaModel;
    }


}
