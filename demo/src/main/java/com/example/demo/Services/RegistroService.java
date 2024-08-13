package com.example.demo.Services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repositories.IRegistroRepository;
import com.example.demo.models.ProductoModel;
import com.example.demo.models.RegistroModel;

import jakarta.transaction.Transactional;

@Service
public class RegistroService {
     @Autowired
    IRegistroRepository iRegistroRepository;
    @Autowired
    ClienteService clienteService;
    @Autowired
    CarritoService carritoService;
    @Autowired 
    ProductoService productoService;

    public ArrayList<RegistroModel> getRegistro(){
        return (ArrayList<RegistroModel>) iRegistroRepository.findAll();
    }

    public Optional<RegistroModel> getByID(Long id){
        return iRegistroRepository.findById(id);
    }
    
    public RegistroModel save(Long dni, String tipoEntrega, Date fecha) {
        List<carritoDTO> productosDTO = carritoService.getProductosPorCliente(dni);
        List<RegistroItem> items = new ArrayList<>();

        for (carritoDTO dto : productosDTO) {
            Optional<ProductoModel> productoOptional = productoService.getById(dto.getIdProducto());
            if (productoOptional.isPresent()) {
                ProductoModel producto = productoOptional.get();
                RegistroItem item = new RegistroItem();
                item.setProducto(producto);
                item.setCantidad(dto.getCantidad());
                items.add(item);
            } else {
                // Manejar el caso donde el producto no existe
                System.out.println("Producto con ID " + dto.getIdProducto() + " no encontrado");
                // Podrías lanzar una excepción aquí si lo prefieres
                // throw new ProductoNotFoundException("Producto con ID " + dto.getIdProducto() + " no encontrado");
            }
        }

        RegistroModel registro = new RegistroModel();
        registro.setTipoentrega(tipoEntrega);
        registro.setFecha(fecha);
        registro.setClienteModel(clienteService.getByDni(dni));
        registro.setItems(items);

        return iRegistroRepository.save(registro);
    }


    
    @Transactional
    public boolean eliminarRegistro(Long id) {
        Optional<RegistroModel> registro = iRegistroRepository.findById(id);
        if (registro.isPresent()) {
            iRegistroRepository.delete(registro.get());
            return true;
        }
        return false;
    }
}
