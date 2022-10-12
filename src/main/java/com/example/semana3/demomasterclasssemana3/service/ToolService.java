package com.example.semana3.demomasterclasssemana3.service;

import com.example.semana3.demomasterclasssemana3.entities.Tool;
import com.example.semana3.demomasterclasssemana3.repository.ToolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToolService {

    @Autowired
    private ToolRepository toolRepository;

    public List<Tool> getAll(){
        return toolRepository.getAll();
    }

    public Optional<Tool> getTool (int id){
        return toolRepository.getTool(id);
    }

    public Tool save (Tool t){
        if (t.getId()==null){
            return toolRepository.save(t);
        }else {
            Optional<Tool> e = toolRepository.getTool(t.getId());
            if (e.isPresent()) {
                return t;
            } else {
                return toolRepository.save(t);
            }
        }
    }

    public Tool update (Tool t){
        if (t.getId()!=null){
            Optional<Tool> q=toolRepository.getTool(t.getId());
            if(q.isPresent()){
                if (t.getName()!=null){
                    q.get().setName(t.getName());
                }
                if (t.getBrand()!=null){
                    q.get().setBrand(t.getBrand());
                }
                if (t.getYear()!=null){
                    q.get().setYear(t.getYear());
                }
                if (t.getDescription()!=null){
                    q.get().setDescription(t.getDescription());
                }
                if (t.getCategory()!=null){
                    q.get().setCategory(t.getCategory());
                }
                toolRepository.save(q.get());
                return q.get();
            }else {
                return t;
            }
        }else {
            return t;
        }
    }

    public boolean delete (int id){
        boolean flag=false;
        Optional<Tool> t = toolRepository.getTool(id);
        if (t.isPresent()){
            toolRepository.delete(t.get());
            flag = true;
        }
        return flag;
    }
}
