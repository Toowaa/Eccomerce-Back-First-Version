package com.example.demo.Services;

public class carritoDTO {
    private Long idCliente;
    private Long idProducto;
    private int cantidad;

    public carritoDTO(int cantidad, Long idCliente, Long idProducto) {
        this.cantidad = cantidad;
        this.idCliente = idCliente;
        this.idProducto = idProducto;
    }

    public carritoDTO() {
    }



    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }


}
