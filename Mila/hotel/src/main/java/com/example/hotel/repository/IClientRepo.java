package com.example.hotel.repository;

import com.example.hotel.model.Client;
import java.util.List;

public interface IClientRepo extends IGenericRepo<Client, Integer> {

    // REQUERIMIENTO DEL PDF: ordenar por apellido
    List<Client> findAllByOrderByLastNameAsc();
}
