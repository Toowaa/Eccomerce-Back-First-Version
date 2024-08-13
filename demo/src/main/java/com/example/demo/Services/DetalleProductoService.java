package com.example.demo.Services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repositories.IDetalleProducto;
import com.example.demo.models.DetalleProductoModel;

@Service
public class DetalleProductoService {
    @Autowired
    IDetalleProducto detalleProducto;

    public ArrayList<DetalleProductoModel>getDetalles(){
        return (ArrayList<DetalleProductoModel>) detalleProducto.findAll();
    }

    public Optional<DetalleProductoModel>getByID(Long id){
        return detalleProducto.findById(id);
    }

    public DetalleProductoModel saveDetalle(DetalleProductoModel detalle){
        return detalleProducto.save(detalle);
    }

    public DetalleProductoModel updateByID(DetalleProductoModel detalle, Long id){
        DetalleProductoModel data= detalleProducto.findById(id).get();
        data.setInsumo(detalle.getInsumo());
        data.setProducto(detalle.getProducto());
        return data;
    }
}
