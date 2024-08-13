package com.example.demo.Services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repositories.IEmpleadoRepository;
import com.example.demo.models.EmpleadoModel;

@Service
public class EmpleadoService {
    @Autowired
    IEmpleadoRepository empleadoRepository;

    public ArrayList<EmpleadoModel>getEmpleados(){
        return (ArrayList<EmpleadoModel>)empleadoRepository.findAll();
    }

    public Optional<EmpleadoModel> getByID(Long id){
        return empleadoRepository.findById(id);
    }

    public EmpleadoModel getByNombre(String nombre){
        return empleadoRepository.getNombreEmpleado(nombre);
    }

    public EmpleadoModel saveEmpleado(EmpleadoModel empleado){
        return empleadoRepository.save(empleado);
    }

    public EmpleadoModel updateEmpleado(EmpleadoModel empleado, Long id){
        EmpleadoModel emp= empleadoRepository.findById(id).get();
        emp.setNombre(empleado.getNombre());
        emp.setApellido(empleado.getApellido());
        emp.setDni(empleado.getDni());
        return emp;
    }
}
