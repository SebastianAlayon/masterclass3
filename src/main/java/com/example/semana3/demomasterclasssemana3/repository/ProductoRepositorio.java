package com.example.semana3.demomasterclasssemana3.repository;

import com.example.semana3.demomasterclasssemana3.entities.Producto;
import com.example.semana3.demomasterclasssemana3.repository.crudRepository.ProductoCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepositorio {

    @Autowired
    private ProductoCrudRepository productoCrudRepository;

    // Listar productos
    public List<Producto> getAll(){
        return (List<Producto>) productoCrudRepository.findAll();
    }

    // Listar un producto por id
    public Optional<Producto> getProduct(int id) {
        return productoCrudRepository.findById(id);
    }
    // Guardar producto
    public Producto save(Producto p) {
        return productoCrudRepository.save(p);
    }

    public void delete (Producto p) {
        productoCrudRepository.delete(p);
    }
}
