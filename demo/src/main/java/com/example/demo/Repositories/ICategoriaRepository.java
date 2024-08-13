package com.example.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.models.CategoriaModel;
@Repository
public interface ICategoriaRepository extends JpaRepository<CategoriaModel, Long> {
    @Query("select category from CategoriaModel category where category.nombre=?1")
    CategoriaModel getCategoriaNombre(String nombre);
}
