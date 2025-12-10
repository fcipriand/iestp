package com.example.hotel.service.impl;

import com.example.hotel.repository.IDetailReservationRepo;
import com.example.hotel.repository.IGenericRepo;
import com.example.hotel.service.IDetailReservationService;
import com.example.hotel.model.DetailReservation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DetailReservationService extends CRUDImpl<DetailReservation, Integer> implements IDetailReservationService {

    private final IDetailReservationRepo repo;

    @Override
    protected IGenericRepo<DetailReservation, Integer> getRepo() {
        return repo;
    }
}
