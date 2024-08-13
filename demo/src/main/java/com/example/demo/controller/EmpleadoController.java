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

import com.example.demo.Services.EmpleadoService;
import com.example.demo.models.EmpleadoModel;

@RestController
@RequestMapping("/empleado")
public class EmpleadoController {
    @Autowired
    EmpleadoService empleadoService;

    @GetMapping
    public ArrayList<EmpleadoModel> GetEmpleados(){
        return(ArrayList<EmpleadoModel>) empleadoService.getEmpleados();
    }

    @GetMapping("/{id}")
    public Optional<EmpleadoModel> getById(@PathVariable("id")Long id){
        return empleadoService.getByID(id);
    }

    @GetMapping("/nombre/{nombre}")
    public EmpleadoModel getNombreEmpleado(@PathVariable("nombre") String nombre){
        return empleadoService.getByNombre(nombre);
    }

    @PutMapping(path = "/{id}")
    public EmpleadoModel updateEmpleado(@RequestBody EmpleadoModel emp,@PathVariable("id") Long id){
        return this.empleadoService.updateEmpleado(emp, id);
    }

    @PostMapping
    public EmpleadoModel saveEmpleado(@RequestBody EmpleadoModel emp){
        return this.empleadoService.saveEmpleado(emp);
    }

}
