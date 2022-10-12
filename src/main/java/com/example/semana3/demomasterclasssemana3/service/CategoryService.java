package com.example.semana3.demomasterclasssemana3.service;

import com.example.semana3.demomasterclasssemana3.entities.Category;
import com.example.semana3.demomasterclasssemana3.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll(){
        return categoryRepository.getAll();
    }

    public Optional<Category> getCategory (int id){
        return categoryRepository.getCategory(id);
    }

    public Category save (Category c){
        if (c.getId()==null){
            return categoryRepository.save(c);
        }else {
            Optional<Category> t= categoryRepository.getCategory(c.getId());
            if (t.isPresent()){
                return c;
            }else {
                return categoryRepository.save(c);
            }
        }
    }

    public Category update (Category c){
        if (c.getId()!=null){
            Optional<Category> t= categoryRepository.getCategory(c.getId());
            if (t.isPresent()){
                if (c.getName()!=null){
                    t.get().setName(c.getName());
                }
                if (c.getDescription()!=null){
                    t.get().setDescription(c.getDescription());
                }
                categoryRepository.save(t.get());
                return t.get();
            }else {
                return c;
            }
        }else {
            return c;
        }
    }

    public boolean delete (int id){
        boolean flag = false;
        Optional<Category> c= categoryRepository.getCategory(id);
        if (c.isPresent()){
            categoryRepository.delete(c.get());
            flag = true;
        }
        return flag;
    }

}
