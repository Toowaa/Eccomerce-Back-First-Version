package com.example.demo.Services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repositories.IDetalleRegistroRepository;
import com.example.demo.models.DetalleRegistro;

@Service
public class DetalleRegistroService {
    @Autowired
    IDetalleRegistroRepository detalleRegistroRepository;

    public ArrayList<DetalleRegistro> getDetalles(){
        return(ArrayList<DetalleRegistro>)detalleRegistroRepository.findAll();

    }

     public Optional<DetalleRegistro>getByID(Long id){
        return detalleRegistroRepository.findById(id);
    }

    public DetalleRegistro saveDetalle(DetalleRegistro detalle){
        return detalleRegistroRepository.save(detalle);
    }

    public DetalleRegistro updateByID(DetalleRegistro detalle, Long id){
        DetalleRegistro data= detalleRegistroRepository.findById(id).get();
        data.setCantidad(detalle.getCantidad());
        data.setPrecio(detalle.getPrecio());
        data.setProducto(detalle.getProducto());
        data.setRegistro(detalle.getRegistro());
        return data;
    }


}
