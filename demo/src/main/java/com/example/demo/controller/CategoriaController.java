package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Services.CategoriaService;
import com.example.demo.models.CategoriaModel;
@CrossOrigin
@RestController
@RequestMapping("/categoria")
public class CategoriaController {
    @Autowired
    CategoriaService categoriaService;
    
    @GetMapping
    public ArrayList<CategoriaModel> getCategoria(){
        return categoriaService.getCategorias();
    }

    @GetMapping(path="/{id}")
    public Optional<CategoriaModel> getCategoriaById(@PathVariable("id") Long id){
        return  categoriaService.getById(id);
    }

    @GetMapping(path = "/nomre/{nombre}")
    public CategoriaModel getCategoriaByNombre(@PathVariable("nombre") String nombre){
        return categoriaService.getByNombre(nombre);
    }

    @PutMapping(path = "/{id}")
    public CategoriaModel updateCategoriaById(@RequestBody CategoriaModel cm,@PathVariable("id") Long id ){
        return categoriaService.updateById(cm, id);
    }

    @PostMapping
    public CategoriaModel saveCategoria(@RequestBody CategoriaModel categoria ){
        return this.categoriaService.saveCategoria(categoria);
    }
    
    @DeleteMapping(path = "/{id}")
    public boolean deleteByID(@PathVariable("id") Long id){
        return categoriaService.deleteByID(id);
    }
    




}
