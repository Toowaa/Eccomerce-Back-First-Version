package com.example.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.models.ClienteModel;
@Repository
public interface IClienteRepository extends JpaRepository<ClienteModel,Long >{

   ClienteModel findByUsuarioAndContraseña(String usuario, String contraseña);


    @Query("select customer from ClienteModel customer where customer.nombre=?1")
    ClienteModel getClienteNombre(String nombre);


    @Query("select customer from ClienteModel customer where customer.usuario=?1")
    ClienteModel getClienteuser(String usuario);

    
    @Query("select customer from ClienteModel customer where customer.dni=?1")
    ClienteModel getClienteDni(Long dni);


}
