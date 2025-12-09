package iestp.edu.pe.service.impl;

import iestp.edu.pe.repository.IRentalRepo;
import iestp.edu.pe.repository.IGenericRepo;
import iestp.edu.pe.service.IRentalService;
import iestp.edu.pe.model.Rental;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RentalService extends CRUDimpl<Rental,Integer> implements IRentalService {

    private final IRentalRepo repo;

    @Override
    protected IGenericRepo<Rental, Integer> getRepo() {
        return repo;
    }

	@Override
	public Map<String, List<String>> getVehiclesWithClients() {

	   
	    return repo.findAll().stream()
	            .flatMap(rental -> rental.getDetails().stream())
	            .collect(Collectors.groupingBy(
	                    detail -> detail.getVehicle().getModel(),
	                    Collectors.mapping(
	                        detail -> detail.getRental().getClient().getFirstName() + " " +
	                                  detail.getRental().getClient().getLastName(),
	                        Collectors.toList()
	                    )
	            ));
	}



   
}
