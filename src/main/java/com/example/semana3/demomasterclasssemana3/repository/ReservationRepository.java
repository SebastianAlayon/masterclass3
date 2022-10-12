package com.example.semana3.demomasterclasssemana3.repository;

import com.example.semana3.demomasterclasssemana3.entities.Reservation;
import com.example.semana3.demomasterclasssemana3.repository.crudRepository.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {

    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    // Listar reservations
    public List<Reservation> getAll(){
        return (List<Reservation>) reservationCrudRepository.findAll();
    }

    // Listar una reservation por id
    public Optional<Reservation> getReservation(int id){
        return reservationCrudRepository.findById(id);
    }

    // Guardar una nueva reservation
    public Reservation save(Reservation r){
        return reservationCrudRepository.save(r);
    }

    // Eliminar una reservation por id
    public void delete (Reservation r){
        reservationCrudRepository.delete(r);
    }

}
