package com.example.hotel.repository;

import com.example.hotel.model.Room;
import java.util.List;

public interface IRoomRepo extends IGenericRepo<Room, Integer> {

    // Si deseas buscar habitaciones disponibles
    List<Room> findByAvailableTrue();
}
