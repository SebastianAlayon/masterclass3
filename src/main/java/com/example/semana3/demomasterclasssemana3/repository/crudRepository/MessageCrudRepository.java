package com.example.semana3.demomasterclasssemana3.repository.crudRepository;


import com.example.semana3.demomasterclasssemana3.entities.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<Message, Integer> {
}
