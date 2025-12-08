package iestp.edu.pe.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Vehicle {
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @EqualsAndHashCode.Include
	    private Integer idVehicle;

	    @Column(nullable = false, length = 10, unique = true)
	    private String plate;   // Placa

	    @Column(nullable = false, length = 50)
	    private String brand;   // Marca

	    @Column(nullable = false, length = 50)
	    private String model;   // Modelo

	    @Column(nullable = false)
	    private Integer year;   // Año del vehículo

	    @Column(nullable = false)
	    private Boolean available; // Disponible para alquiler

}
