package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Services.DatosEmpresaService;
import com.example.demo.models.DatosEmpresaModel;

@RestController
@RequestMapping("/Dato")
public class DatoEmpresaController {
    @Autowired
    DatosEmpresaService datosEmpresaService;

    @GetMapping 
    public List<DatosEmpresaModel> getDatos(){
        return datosEmpresaService.getDatos();
    }

    @GetMapping(path = "/{id}")
    public Optional<DatosEmpresaModel> getdatoByid(@PathVariable("id") Long id){
        return datosEmpresaService.getById(id);
    }

    @PutMapping(path = "/{id}")
    public DatosEmpresaModel updatEmpresaModelByid(@RequestBody DatosEmpresaModel da,@PathVariable("id") Long id){
        return this.datosEmpresaService.updatebyId(da, id);
    }

    @PostMapping
    public DatosEmpresaModel saveDato(@RequestBody DatosEmpresaModel dato){
        return this.datosEmpresaService.savedato(dato);
    }
}
