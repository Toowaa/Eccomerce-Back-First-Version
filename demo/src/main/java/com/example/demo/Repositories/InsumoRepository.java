package com.example.demo.Repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.InsumoModel;
@Repository
public interface InsumoRepository  extends JpaRepository<InsumoModel, Long>{

}
