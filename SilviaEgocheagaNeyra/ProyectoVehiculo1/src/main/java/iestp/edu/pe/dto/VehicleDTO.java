package iestp.edu.pe.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDTO {
	   private Integer idVehicle;

	    @NotNull
	    private String plate;   // Placa

	    @NotNull
	    private String brand;   // Marca

	    @NotNull
	    private String model;   // Modelo

	    @NotNull
	    private Integer year;   // Año del vehículo

	    @NotNull
	    private Boolean available; // Disponible para alquiler
}
