package com.rest.productos.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.productos.Entity.Producto;
import com.rest.productos.Service.ProductoService;

@RestController
public class ProductoController {
    
    @Autowired
    private ProductoService productoService;

    @GetMapping("/productos")
    public List<Producto> listarProductos(){
        return productoService.listarProductos();
    }

    @GetMapping("/productos/{id}")
    public ResponseEntity<Producto> obteneProducto(@PathVariable Integer id){
        try {
            Producto producto = productoService.obtenerProductoPorId(id);
            return new ResponseEntity<Producto>(producto, HttpStatus.OK);
        } catch (Exception excepcion) {
            return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/productos")
    public void guardarProducto(@RequestBody Producto producto){
        productoService.guardarProducto(producto);
    }
    
    @PutMapping("/productos/{id}")
    public ResponseEntity<?> actualizarProducto(@RequestBody Producto producto, @PathVariable Integer id){
        try {
            Producto productoActual = productoService.obtenerProductoPorId(id);
            productoActual.setNombre(producto.getNombre());
            productoActual.setMarca(producto.getMarca());
            productoActual.setHechoEn(producto.getHechoEn());
            productoActual.setPrecio(producto.getPrecio());
            productoService.guardarProducto(productoActual);
            return new ResponseEntity<Producto>(HttpStatus.OK);
        } catch (Exception excepcion) {
            return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/productos/{id}")
    public void eliminarProducto(@PathVariable Integer id){
        productoService.eliminarProducto(id);  
    }
}
