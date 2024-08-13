package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Services.DetalleProductoService;
import com.example.demo.models.DetalleProductoModel;

@RestController
@RequestMapping("/detalle_Producto")
public class DetalleProductoController {
    @Autowired
    DetalleProductoService detalleProductoService;

    @GetMapping
    public ArrayList<DetalleProductoModel> getDetalles(){
        return detalleProductoService.getDetalles();
    }

    @GetMapping(path = "/{id}")
    public Optional<DetalleProductoModel>getCursosID(@PathVariable("id") Long id){
        return detalleProductoService.getByID(id);
    }

    @PutMapping(path = "/{id}")
    public DetalleProductoModel updateDetalleByID(@RequestBody DetalleProductoModel dp,@PathVariable("id") Long id) {
        return this.detalleProductoService.updateByID(dp, id);
    }

    @PostMapping
    public DetalleProductoModel savedetalle(@RequestBody DetalleProductoModel detalle){
        return this.detalleProductoService.saveDetalle(detalle);
    }
}
