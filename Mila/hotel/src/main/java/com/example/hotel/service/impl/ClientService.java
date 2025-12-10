package com.example.hotel.service.impl;

import com.example.hotel.repository.IClientRepo;
import com.example.hotel.repository.IGenericRepo;
import com.example.hotel.service.IClientService;
import com.example.hotel.model.Client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientService extends CRUDImpl<Client, Integer> implements IClientService {

    private final IClientRepo repo;

    @Override
    protected IGenericRepo<Client, Integer> getRepo() {
        return repo;
    }
}
