package com.example.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.DetalleRegistro;

@Repository
public interface IDetalleRegistroRepository extends JpaRepository<DetalleRegistro, Long>{

}
