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

import com.example.demo.Services.ComprobanteService;
import com.example.demo.models.ComprobanteModel;

@RestController
@RequestMapping("/comprobante")
public class ComprobanteController {
    @Autowired
    ComprobanteService comprobanteService;

    @GetMapping
    public ArrayList<ComprobanteModel> getComprobantes(){
        return comprobanteService.GetComprobantes();
    }

    @GetMapping(path = "/{id}")
    public Optional<ComprobanteModel> getComprobanteByID(@PathVariable("id") Long id){
        return comprobanteService.getById(id);
    }

    @PutMapping(path = "/{id}")
    public ComprobanteModel updateComprobanteModelByID(@RequestBody ComprobanteModel compr, @PathVariable("id") Long id){
        return this.comprobanteService.updateById(compr, id);
    }

    @PostMapping
    public ComprobanteModel saveComprobante(@RequestBody ComprobanteModel comprobante){
        return this.comprobanteService.saveComprobante(comprobante);
    }
}
