package com.example.demo.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.CarritoModel;
@Repository
public interface ICarritoRepository  extends JpaRepository<CarritoModel, Long>{
    List<CarritoModel> findByClienteModel_Dni(Long dni);

    void deleteByClienteModel_Dni(Long dni);

    Optional<CarritoModel> findByClienteModel_DniAndProductoModel_Id(Long dni, Long idProducto);

}
