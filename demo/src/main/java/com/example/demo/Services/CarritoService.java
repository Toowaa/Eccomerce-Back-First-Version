package com.example.demo.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repositories.ICarritoRepository;
import com.example.demo.Repositories.IClienteRepository;
import com.example.demo.Repositories.IProductoRepository;
import com.example.demo.models.CarritoModel;
import com.example.demo.models.ClienteModel;
import com.example.demo.models.ProductoModel;

import jakarta.transaction.Transactional;

@Service
public class CarritoService {
    @Autowired
    ICarritoRepository carritoRepository;

    @Autowired
    private IClienteRepository clienteRepository;

    @Autowired
    private IProductoRepository productoRepository;


    public ArrayList<CarritoModel> getCompras(){
        return (ArrayList<CarritoModel>) carritoRepository.findAll();
    }
    
 

    public CarritoModel agregarProductoAlCarrito(carritoDTO carritoDTO) {
        CarritoModel carrito = new CarritoModel();
        
        ClienteModel cliente = clienteRepository.findById(carritoDTO.getIdCliente())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        ProductoModel producto = productoRepository.findById(carritoDTO.getIdProducto())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        carrito.setClienteModel(cliente);
        carrito.setProductoModel(producto);
        carrito.setCantidad(carritoDTO.getCantidad());

        return carritoRepository.save(carrito);
    }
   

    public List<carritoDTO> getProductosPorCliente(Long dni) {
        ClienteModel cliente = clienteRepository.findById(dni)
            .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        
        List<CarritoModel> carritos = carritoRepository.findByClienteModel_Dni(dni);
        return carritos.stream()
            .map(carrito -> new carritoDTO(
                carrito.getCantidad(),  
                carrito.getClienteModel().getDni(),
                carrito.getProductoModel().getId()))
            .collect(Collectors.toList());
    }

    public CarritoModel updateCantidad(Long dni, Long idProducto, int cantidad) {
        ClienteModel cliente = clienteRepository.findById(dni)
            .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
    
        CarritoModel carrito = carritoRepository.findByClienteModel_DniAndProductoModel_Id(dni, idProducto)
            .orElseThrow(() -> new RuntimeException("Producto no encontrado en el carrito del cliente"));
    
        carrito.setCantidad(cantidad);
        return carritoRepository.save(carrito);
    }


    @Transactional
    public void borrarCarritoPorCliente(Long dni) {
        ClienteModel cliente = clienteRepository.findById(dni)
            .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        
        carritoRepository.deleteByClienteModel_Dni(dni);
    }

    @Transactional
    public void borrarCarritoPorProducto(Long id) {
        ClienteModel cliente = clienteRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        
        carritoRepository.deleteByClienteModel_Dni(id);
    }

    public carritoDTO updateById(carritoDTO carrito, Long id) {
        CarritoModel carritoExistente = carritoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Carrito no encontrado"));
        
        carritoExistente.setCantidad(carrito.getCantidad());
        // Actualizar cliente y producto si es necesario
        
        CarritoModel carritoActualizado = carritoRepository.save(carritoExistente);
        return new carritoDTO(
            carritoActualizado.getCantidad(),
            carritoActualizado.getClienteModel().getDni(),
            carritoActualizado.getProductoModel().getId()
        );
    }
}
