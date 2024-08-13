package com.example.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.RegistroModel;

@Repository
public interface IRegistroRepository extends JpaRepository<RegistroModel,Long>{

}
