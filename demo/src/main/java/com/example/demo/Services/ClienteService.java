package com.example.demo.Services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repositories.IClienteRepository;
import com.example.demo.models.ClienteModel;

@Service
public class ClienteService {
    @Autowired
    IClienteRepository clienteRepository;

    public ArrayList<ClienteModel> getClientes(){
        return (ArrayList<ClienteModel>) clienteRepository.findAll();
    }

    public Optional<ClienteModel>getById(Long id){
        return clienteRepository.findById(id);
    }

    public ClienteModel getByNombre(String nombre){
        return clienteRepository.getClienteNombre(nombre);
    }

    public ClienteModel getByDni(Long dni){
        return clienteRepository.getClienteDni(dni);
    }

    public ClienteModel getByUser(String usuario){
        return clienteRepository.getClienteuser(usuario);
    }

    public ClienteModel saveCliente(ClienteModel cliente){
        return clienteRepository.save(cliente);
    }
      
    public ClienteModel getByUsernameAndPassword(String usuario, String contraseña) {
        return clienteRepository.findByUsuarioAndContraseña(usuario, contraseña);
    }

    public ClienteModel updateById(ClienteModel cliente,Long id){
        ClienteModel customer= clienteRepository.findById(id).get();
        customer.setNombre(cliente.getNombre());
        customer.setApellido(cliente.getApellido());
        customer.setDireccion(cliente.getDireccion());
        customer.setTelefono(cliente.getTelefono());
        customer.setDni(cliente.getDni());
        return  customer;
    }

    
}
