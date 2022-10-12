package com.example.semana3.demomasterclasssemana3.controller;

import com.example.semana3.demomasterclasssemana3.entities.Producto;
import com.example.semana3.demomasterclasssemana3.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("/all")
    public List<Producto> getAll () {
        return productoService.getAll();
    }

    @PostMapping("/save")
    public Producto save(@RequestBody Producto p){
        return productoService.save(p);
    }

}
