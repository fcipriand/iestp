package iestp.edu.pe.service;

import iestp.edu.pe.model.Rental;

import java.util.List;
import java.util.Map;

public interface IRentalService extends ICRUD<Rental,Integer> {
	
	Map<String, List<String>> getVehiclesWithClients();


}
