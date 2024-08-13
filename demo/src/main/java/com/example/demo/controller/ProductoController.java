package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Map;
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

import com.example.demo.Services.ProductoService;
import com.example.demo.models.ProductoModel;


@CrossOrigin
@RestController
@RequestMapping("/Producto")
public class ProductoController {
        @Autowired
        private ProductoService productoService;

        @GetMapping
        public ArrayList<ProductoModel> getProductos(){
            return this.productoService.getProductos();
        }

        @PostMapping
        public ProductoModel saveProducto(@RequestBody ProductoModel producto){
            return this.productoService.saveProducto(producto);

        }

        @GetMapping(path = "/{id}")
        public Optional<ProductoModel> getById(@PathVariable("id") Long id){
            return productoService.getById(id);
        }
        

        @PutMapping(path = "/{id}")
        public ProductoModel updateById( @RequestBody ProductoModel producto, @PathVariable("id") Long id){
         return productoService.updateById(producto, id);
        }
        
        @DeleteMapping(path = "/{id}")  
        public boolean deletebyID(@PathVariable("id") Long id){
            return productoService.deletebyID(id);
        }
        @PutMapping(path="/stock/{id}")
        public ProductoModel updateStock(@PathVariable Long id, @RequestBody Map<String, Integer> stockMap){
            int stock = stockMap.get("stock");
            return productoService.updateStock(id, stock);
        }
        
}
