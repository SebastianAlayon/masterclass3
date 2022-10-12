package com.example.semana3.demomasterclasssemana3.controller;

import com.example.semana3.demomasterclasssemana3.entities.Tool;
import com.example.semana3.demomasterclasssemana3.service.ToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Tool")
public class ToolController {

    @Autowired
    private ToolService toolService;

    @GetMapping("/all")
    public List<Tool> getAll (){
        return toolService.getAll();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Tool save (@RequestBody Tool t){
        return toolService.save(t);
    }
}
