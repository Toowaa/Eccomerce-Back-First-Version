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

import com.example.demo.Services.InsumoService;
import com.example.demo.models.InsumoModel;



@RestController
@RequestMapping("/Insumo")
public class InsumoController {
        @Autowired
        private InsumoService insumoService;

         @GetMapping
         public ArrayList<InsumoModel> getInsumo(){
            return this.insumoService.getInsumo();
         }

         @PostMapping
         public InsumoModel savInsumoModel(@RequestBody InsumoModel insumo){
            return this.insumoService.saveInsumoModel(insumo);
         }

         @GetMapping(path="/{id}")
         public Optional<InsumoModel>getById(@PathVariable("id")Long id){
            return insumoService.getById(id);
         }

         @PutMapping
         public InsumoModel  updateById(
            @RequestBody InsumoModel insumo,
            @PathVariable ("id")    Long id){
                return insumoService.updateById(insumo, id);
            }
         
}
