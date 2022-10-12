package com.example.semana3.demomasterclasssemana3.repository;

import com.example.semana3.demomasterclasssemana3.entities.Category;
import com.example.semana3.demomasterclasssemana3.repository.crudRepository.CategoryCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepository {

    @Autowired
    private CategoryCrudRepository categoryCrudRepository;

    // Listar categorias
    public List<Category> getAll () {
        return (List<Category>) categoryCrudRepository.findAll();
    }

    // Encontrar por id
    public Optional<Category> getCategory(int id){
        return categoryCrudRepository.findById(id);
    }

    // Crear Categoria
    public Category save(Category c){
        return categoryCrudRepository.save(c);
    }

    // Eliminar Categoria
    public void delete(Category c){
        categoryCrudRepository.delete(c);
    }

}
