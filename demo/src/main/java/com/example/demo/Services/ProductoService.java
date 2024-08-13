package com.example.demo.Services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repositories.IProductoRepository;
import com.example.demo.models.ProductoModel;


@Service
public class ProductoService {
    @Autowired
    IProductoRepository ProductoRepository;
 

    public ArrayList<ProductoModel> getProductos(){
        return (ArrayList<ProductoModel>) ProductoRepository.findAll();
    }

    public ProductoModel saveProducto(ProductoModel producto ){
        return ProductoRepository.save(producto);
    }
    
         public Optional<ProductoModel> getById(Long id){
            return ProductoRepository.findById(id);
        }

        /*public ProductoDTO getById(Long id) {
            ProductoModel productoModel = ProductoRepository.findById(id)
                                        .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
            
            ProductoDTO productoDetalleDTO = new ProductoDTO();
            productoDetalleDTO.setId(productoModel.getId());
            productoDetalleDTO.setNombre(productoModel.getNombre());
            productoDetalleDTO.setDescripcion(productoModel.getDescripcion());
            productoDetalleDTO.setStock(productoModel.getStock());
            productoDetalleDTO.setPrecio(productoModel.getPrecio());
            productoDetalleDTO.setCategoriaModel(productoModel.getCategoriaModel());
            
            return productoDetalleDTO;
        }*/

    public ProductoModel updateById(ProductoModel request, Long id){
        ProductoModel pro=ProductoRepository.findById(id).get();
        pro.setNombre(request.getNombre());
        pro.setDescripcion(request.getDescripcion());
        pro.setPrecio(request.getPrecio());
        pro.setStock(request.getStock());
        pro.setCategoriaModel(request.getCategoriaModel());
        return ProductoRepository.save(pro);
    }

    public ProductoModel updateStock(Long id, int stock) {
        ProductoModel producto = ProductoRepository.findById(id).get();           
        producto.setStock(stock);
        return ProductoRepository.save(producto);
    }
    


    public boolean deletebyID(Long id){
        ProductoRepository.deleteById(id);
        return true;
    }
}
