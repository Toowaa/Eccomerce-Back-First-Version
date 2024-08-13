package com.example.demo.Services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repositories.IDireccionRepository;
import com.example.demo.models.DireccionCModel;

@Service
public class DireccionService {
    @Autowired
    IDireccionRepository direccionRepository;

    public ArrayList<DireccionCModel> getDirecciones(){
        return (ArrayList<DireccionCModel>)direccionRepository.findAll();
    }

    public Optional<DireccionCModel> getById(Long id){
    return direccionRepository.findById(id);
    }
    public DireccionCModel saveDireccion(DireccionCModel direccion){
        return direccionRepository.save(direccion);
    }

    public DireccionCModel updateById(DireccionCModel direccion, Long id){
        DireccionCModel direc= direccionRepository.findById(id).get();
        direc.setId(direccion.getId());
        direc.setCalle(direccion.getCalle());
        direc.setCiudad(direccion.getCiudad());
        direc.setCodigopostal(direccion.getCodigopostal());
        direc.setNumero_exterior(direccion.getNumero_exterior());
        direc.setTipodireccion(direccion.getTipodireccion());
        return direc;
    }
}
