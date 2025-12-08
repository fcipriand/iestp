package iestp.edu.pe.service.impl;

import iestp.edu.pe.repository.IVehicleRepo;
import iestp.edu.pe.repository.IGenericRepo;
import iestp.edu.pe.service.IVehicleService;
import iestp.edu.pe.model.Vehicle;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleService extends CRUDimpl<Vehicle,Integer> implements IVehicleService {

    private final IVehicleRepo repo;

    @Override
    protected IGenericRepo<Vehicle, Integer> getRepo() {
        return repo;
    }

   
    
}
