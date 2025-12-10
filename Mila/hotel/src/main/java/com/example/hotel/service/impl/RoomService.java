package com.example.hotel.service.impl;

import com.example.hotel.repository.IRoomRepo;
import com.example.hotel.repository.IGenericRepo;
import com.example.hotel.service.IRoomService;
import com.example.hotel.model.Room;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoomService extends CRUDImpl<Room, Integer> implements IRoomService {

    private final IRoomRepo repo;

    @Override
    protected IGenericRepo<Room, Integer> getRepo() {
        return repo;
    }
}
