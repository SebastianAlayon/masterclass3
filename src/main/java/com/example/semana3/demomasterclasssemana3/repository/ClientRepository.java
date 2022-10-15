package com.example.semana3.demomasterclasssemana3.repository;

import com.example.semana3.demomasterclasssemana3.entities.Client;
import com.example.semana3.demomasterclasssemana3.repository.crudRepository.ClientCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository {

    @Autowired
    private ClientCrudRepository clientCrudRepository;

    // Listar  todos los clients
    public List<Client> getAll() {
        return (List<Client>) clientCrudRepository.findAll();
    }

    // Listar un client por id
    public Optional<Client> getClient (int id){
        return clientCrudRepository.findById(id);
    }

    // Guardar un client
    public Client save(Client c){
        return clientCrudRepository.save(c);
    }

    // Eliminar un client
    public void delete (Client c){
        clientCrudRepository.delete(c);
    }
}
