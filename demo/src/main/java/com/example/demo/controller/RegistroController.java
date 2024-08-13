package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Services.RegistroService;
import com.example.demo.models.RegistroModel;
@CrossOrigin    
@RestController
@RequestMapping("/registro")
public class RegistroController {
    
    @Autowired
    private RegistroService registroService;

    @GetMapping()
    public ArrayList<RegistroModel> obtenerRegistros() {
        return registroService.getRegistro();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegistroModel> obtenerRegistroPorId(@PathVariable Long id) {
        Optional<RegistroModel> registro = registroService.getByID(id);
        if (registro.isPresent()) {
            return ResponseEntity.ok(registro.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{id}/{tipoentrega}/{fecha}")
    public ResponseEntity<RegistroModel> crearRegistro(
            @PathVariable Long id,
            @PathVariable String tipoentrega,
             @PathVariable @DateTimeFormat(pattern="dd-MM-yyyy") Date fecha

) {
        try {
            RegistroModel nuevoRegistro = registroService.save(id, tipoentrega, fecha);
            return new ResponseEntity<>(nuevoRegistro, HttpStatus.CREATED);
        } catch (Exception e) {
            // Manejo de errores
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

 

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarRegistro(@PathVariable Long id) {
        boolean eliminado = registroService.eliminarRegistro(id);
        if (eliminado) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}