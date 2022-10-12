package com.example.semana3.demomasterclasssemana3.repository;

import com.example.semana3.demomasterclasssemana3.entities.Message;
import com.example.semana3.demomasterclasssemana3.repository.crudRepository.MessageCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MessageRepository {

    @Autowired
    private MessageCrudRepository messageCrudRepository;

    // Listar todos los menssage
    public List<Message> getAll() {
        return (List<Message>) messageCrudRepository.findAll();
    }

    // Listar message por id
    public Optional<Message> getMessage (int id){
        return messageCrudRepository.findById(id);
    }

    // Guardar un nuevo message
    public Message save(Message m){
        return messageCrudRepository.save(m);
    }

    // Eliminar un message
    public void delete(Message m){
        messageCrudRepository.delete(m);
    }

}


