package com.rest.productos.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rest.productos.Entity.Producto;

public interface IProductoRepository extends JpaRepository<Producto, Integer>{
    
}
