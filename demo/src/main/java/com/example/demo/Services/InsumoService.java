package com.example.demo.Services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repositories.InsumoRepository;
import com.example.demo.models.InsumoModel;



@Service
public class InsumoService {
    @Autowired
    InsumoRepository insumoRepository;

    public ArrayList<InsumoModel> getInsumo(){
        return (ArrayList<InsumoModel>) insumoRepository.findAll();
    }
    public InsumoModel saveInsumoModel(InsumoModel insumo){
        return insumoRepository.save(insumo);
    }

    public Optional<InsumoModel> getById(Long id){
        return insumoRepository.findById(id);
    }

    public InsumoModel updateById(InsumoModel request, Long id){
        InsumoModel insumo=insumoRepository.findById(id).get();
        insumo.setNombre(request.getNombre());
        insumo.setPrecio(request.getPrecio());
        insumo.setStock(request.getStock());
        return  insumo;
    }


    
}
