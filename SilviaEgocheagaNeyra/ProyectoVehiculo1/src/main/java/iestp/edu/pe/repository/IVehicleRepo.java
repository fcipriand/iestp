package iestp.edu.pe.repository;

import iestp.edu.pe.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVehicleRepo extends IGenericRepo<Vehicle,Integer> {
   // Category getCustomcategory();

}
