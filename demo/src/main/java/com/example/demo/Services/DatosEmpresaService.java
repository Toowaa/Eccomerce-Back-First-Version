package com.example.demo.Services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repositories.IDatosEmpresaRepository;
import com.example.demo.models.DatosEmpresaModel;

@Service
public class DatosEmpresaService {
    @Autowired
    IDatosEmpresaRepository datosEmpresaRepository;

    public List<DatosEmpresaModel> getDatos(){
        return datosEmpresaRepository.findAll();
    }

    public Optional<DatosEmpresaModel> getById(Long id){
        return datosEmpresaRepository.findById(id);
    }   

    public DatosEmpresaModel savedato(DatosEmpresaModel dato){
        return datosEmpresaRepository.save(dato);
    }

    public DatosEmpresaModel updatebyId(DatosEmpresaModel dato,Long id){
        DatosEmpresaModel dat=datosEmpresaRepository.findById(id).get();
        dat.setNombre(dato.getNombre());
        dat.setRUC(dato.getRUC());
        dat.setUbicacion(dato.getUbicacion());
        return dat;
    }

}
