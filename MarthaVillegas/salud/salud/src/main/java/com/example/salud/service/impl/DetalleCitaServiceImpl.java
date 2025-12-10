package com.example.salud.service.impl;

import com.example.salud.model.DetalleCita;
import com.example.salud.repository.IDetalleCitaRepo;
import com.example.salud.repository.IGenericRepo;
import com.example.salud.service.IDetalleCitaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DetalleCitaServiceImpl extends CRUDImpl<DetalleCita, Integer> implements IDetalleCitaService {

    private final IDetalleCitaRepo repo;

    @Override
    protected IGenericRepo<DetalleCita, Integer> getRepo() {
        return repo;
    }
}
