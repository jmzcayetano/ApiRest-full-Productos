package com.rest.productos.Service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.rest.productos.Entity.Producto;
import com.rest.productos.Repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ProductoService {
    
    @Autowired
    private IProductoRepository iProductoRepository;

    //METODO
    public List<Producto> listarProductos(){
        return iProductoRepository.findAll();
    }

    public void guardarProducto(Producto producto){
        iProductoRepository.save(producto);
    }

    public Producto obtenerProductoPorId(Integer id){
        return iProductoRepository.findById(id).get();
    }

    public void eliminarProducto(Integer id){
        iProductoRepository.deleteById(id);
    }
}
