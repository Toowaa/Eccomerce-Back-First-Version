package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Services.DireccionService;
import com.example.demo.models.DireccionCModel;
@CrossOrigin
@RestController
@RequestMapping("/direcciones")
public class DireccionController {
    @Autowired
    DireccionService direccionService;

    @GetMapping
    public ArrayList<DireccionCModel> getDireccion(){
        return direccionService.getDirecciones();
    }

    @GetMapping(path = "/{id}")
    public Optional<DireccionCModel> getByID(@PathVariable("id") Long id){
        return direccionService.getById(id);
    }

    @PutMapping(path = "/{id}")
    public DireccionCModel updateDireccion(@RequestBody DireccionCModel direc,@PathVariable("id") Long id){
        return this.direccionService.updateById(direc, id);
    }

    @PostMapping
    public DireccionCModel SaveDireccion(@RequestBody DireccionCModel direc){
        return this.direccionService.saveDireccion(direc);
    }
}
