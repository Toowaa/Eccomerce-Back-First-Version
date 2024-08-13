package com.example.demo.Services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repositories.IComprobanteRepository;
import com.example.demo.models.ComprobanteModel;

@Service
public class ComprobanteService {
    @Autowired
    IComprobanteRepository comprobanteRepository;

    public ArrayList<ComprobanteModel> GetComprobantes(){
        return (ArrayList<ComprobanteModel>) comprobanteRepository.findAll();
    }

    public Optional<ComprobanteModel>getById(Long id){
        return comprobanteRepository.findById(id);
    }

    public ComprobanteModel saveComprobante(ComprobanteModel comprobante){
        return comprobanteRepository.save(comprobante);
    }

    public ComprobanteModel updateById(ComprobanteModel comprobante,Long id){
        ComprobanteModel voucher= comprobanteRepository.findById(id).get();
        comprobante.setTipoDeMoneda(comprobante.getTipoDeMoneda());
        comprobante.setDatosempresas(comprobante.getDatosempresas());
        comprobante.setRegistro(comprobante.getRegistro());
        return voucher;
    }
    
}
