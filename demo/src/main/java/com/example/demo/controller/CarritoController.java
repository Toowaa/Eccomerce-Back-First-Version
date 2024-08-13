package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Services.CarritoService;
import com.example.demo.Services.carritoDTO;
import com.example.demo.models.CarritoModel;




@CrossOrigin
@RestController
@RequestMapping("/buy")
public class CarritoController {
        @Autowired
        CarritoService carritoService;

        @GetMapping
        public  ArrayList<CarritoModel> getcompras(){
            return carritoService.getCompras();
        }
        
    
        @PostMapping
        public ResponseEntity<CarritoModel> agregarProductoAlCarrito(@RequestBody carritoDTO carritoDTO) {
            CarritoModel carrito = carritoService.agregarProductoAlCarrito(carritoDTO);
            return new ResponseEntity<>(carrito, HttpStatus.CREATED);
        }
        
        @GetMapping("/cliente/{dni}/productos")
        public ResponseEntity<List<carritoDTO>> getProductosPorCliente(@PathVariable Long dni) {
            List<carritoDTO> productos = carritoService.getProductosPorCliente(dni);
            return new ResponseEntity<>(productos, HttpStatus.OK);
        }

        @DeleteMapping("/borrar/{dni}")
        public ResponseEntity<?> borrarCarrito(@PathVariable Long dni) {
        try {
            carritoService.borrarCarritoPorCliente(dni);
            return ResponseEntity.ok().body(Map.of("mensaje", "Carrito borrado exitosamente"));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", e.getMessage()));
        }
    }
        @PutMapping("/{id}")
        public ResponseEntity<carritoDTO> actualizarCarrito(@PathVariable Long id, @RequestBody carritoDTO carritoDTO) {
            return ResponseEntity.ok(carritoService.updateById(carritoDTO, id));
        }
        @PutMapping("/carrito/{dni}/{idProducto}")
        public CarritoModel updateCantidad(@PathVariable Long dni, @PathVariable Long idProducto, @RequestBody Map<String, Integer> cantidadMap) {
            int cantidad = cantidadMap.get("cantidad");
            return carritoService.updateCantidad(dni, idProducto, cantidad);
        }

        
    }


