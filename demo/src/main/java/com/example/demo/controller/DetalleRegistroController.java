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

import com.example.demo.Services.DetalleRegistroService;
import com.example.demo.models.DetalleRegistro;

@RestController
@RequestMapping("/detalleRegistro")
public class DetalleRegistroController {
    @Autowired
    DetalleRegistroService detalleRegistroService;

    @GetMapping
    public ArrayList<DetalleRegistro> getdetalles(){
        return detalleRegistroService.getDetalles();
    }

    @GetMapping(path="/{id}")
    public Optional<DetalleRegistro> getdetalleByID(@PathVariable("id") Long id) {
        return detalleRegistroService.getByID(id);
    }

    @PutMapping(path="/{id}")
    public DetalleRegistro updateDetalleRegistro(@RequestBody DetalleRegistro dere,@PathVariable("id")Long id){
        return this.detalleRegistroService.updateByID(dere, id);
    }

    @PostMapping 
    public DetalleRegistro saveDetalle(@RequestBody DetalleRegistro detalle){
        return this.detalleRegistroService.saveDetalle(detalle);
    }
}
