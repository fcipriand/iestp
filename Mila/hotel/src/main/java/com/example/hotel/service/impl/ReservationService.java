package com.example.hotel.service.impl;

import com.example.hotel.repository.IReservationRepo;
import com.example.hotel.repository.IGenericRepo;
import com.example.hotel.service.IReservationService;
import com.example.hotel.model.Reservation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReservationService extends CRUDImpl<Reservation, Integer> implements IReservationService {

    private final IReservationRepo repo;

    @Override
    protected IGenericRepo<Reservation, Integer> getRepo() {
        return repo;
    }
}
