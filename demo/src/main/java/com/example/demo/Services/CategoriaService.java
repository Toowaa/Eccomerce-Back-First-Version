package com.example.demo.Services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repositories.ICategoriaRepository;
import com.example.demo.models.CategoriaModel;

@Service
public class CategoriaService {
    @Autowired
    ICategoriaRepository categoriaRepository;

    public ArrayList<CategoriaModel> getCategorias(){
        return (ArrayList<CategoriaModel>) categoriaRepository.findAll();
    }

    public Optional<CategoriaModel>getById (Long id){
        return categoriaRepository.findById(id);
    }  

    public CategoriaModel getByNombre(String nombre){
        return categoriaRepository.getCategoriaNombre(nombre);
    }  

    public boolean  deleteByID(Long id){
        categoriaRepository.deleteById(id);
        return true;
    }

    public CategoriaModel saveCategoria(CategoriaModel categoria){
        return  categoriaRepository.save(categoria);
    }

    public CategoriaModel updateById(CategoriaModel categoria, long id){
        CategoriaModel category= categoriaRepository.findById(id).get();
        category.setNombre(categoria.getNombre());
        category.setCategoria(categoria.getCategoria());
        return categoriaRepository.save(category);
    }

}
