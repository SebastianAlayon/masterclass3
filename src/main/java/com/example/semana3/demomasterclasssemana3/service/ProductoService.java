package com.example.semana3.demomasterclasssemana3.service;

import com.example.semana3.demomasterclasssemana3.entities.Producto;
import com.example.semana3.demomasterclasssemana3.repository.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepositorio productoRepositorio;

    public List<Producto> getAll(){
        return productoRepositorio.getAll();
    }

    public Optional<Producto> getProducto (int id){
        return productoRepositorio.getProduct(id);
    }

    public Producto save(Producto p){
        if (p.getId()==null){
            return productoRepositorio.save(p);
        }else{
            Optional<Producto> e = productoRepositorio.getProduct(p.getId());
            if (e.isPresent()){
                return p;
            }else {
                return productoRepositorio.save(p);
            }
        }
    }

    public Producto update(Producto p){
        if (p.getId()!=null){
            Optional<Producto> q=productoRepositorio.getProduct(p.getId());
            if (q.isPresent()){
                if (p.getNombre()!=null){
                    q.get().setNombre(p.getNombre());
                }
                if (p.getYear()!=null){
                    q.get().setYear(p.getYear());
                }
                if (p.getCategoria()!=null){
                    q.get().setCategoria(p.getCategoria());
                }
                productoRepositorio.save(q.get());
                return q.get();
            }else {
                return p;
            }
        }else {
            return p;
        }
    }

    public boolean delete(int id){
        boolean flag=false;
        Optional<Producto>p=productoRepositorio.getProduct(id);
        if (p.isPresent()){
            productoRepositorio.delete(p.get());
            flag = true;
        }
        return flag;
    }

}
