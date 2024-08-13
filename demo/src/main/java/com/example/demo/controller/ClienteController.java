package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Services.ClienteService;
import com.example.demo.Services.LoginRequest;
import com.example.demo.models.ClienteModel;

@CrossOrigin
@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    @GetMapping
    public ArrayList<ClienteModel> GetClientes(){
        return clienteService.getClientes();
    }

    @GetMapping(path = "/{id}")
    public Optional<ClienteModel> getClienteByID(@PathVariable("id") Long id){
        return clienteService.getById(id);
    }
    
    @GetMapping(path = "/nombre/{nombre}")
    public ClienteModel getClienteByNombre(@PathVariable("nombre") String nombre){
        return clienteService.getByNombre(nombre);
    }
    @GetMapping(path = "/dni/{dni}")
    public ClienteModel getClienteByDni(@PathVariable("dni")Long dni){
        return clienteService.getByDni(dni);
    }

    @GetMapping(path="/user/{usuario}")
    public ClienteModel getUser(@PathVariable("usuario") String usuario){
        return clienteService.getByUser(usuario);
    }

    


    @PutMapping(path="/{id}")
    public ClienteModel updaClienteModelByID(@RequestBody ClienteModel cli ,@PathVariable("id") Long id ){
    return this.clienteService.updateById(cli,id);
    }    

    @PostMapping
    public ClienteModel Savecliente(@RequestBody ClienteModel cliente){
        return this.clienteService.saveCliente(cliente);
    }

    @PostMapping("/login")
    public ResponseEntity<ClienteModel> loginCliente(@RequestBody LoginRequest loginRequest) {
        ClienteModel cliente = clienteService.getByUsernameAndPassword(loginRequest.getUsername(), loginRequest.getPassword());
        
        if (cliente != null) {
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

}
