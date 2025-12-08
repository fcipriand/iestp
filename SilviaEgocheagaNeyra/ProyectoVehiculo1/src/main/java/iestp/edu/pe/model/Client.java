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
public class Client {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @EqualsAndHashCode.Include
	    private Integer idClient;

	   @Column(nullable = false, length = 25)
	    private String firstName;
	    
	   @Column(nullable = false, length = 25)
	    private String lastName;

	    @Column(length = 8, unique = true)
	    private String dni;

	    @Column(nullable = false, length = 10)
	    private String phone;

	    @Column(name = "driver_license")
	    private String driverLicense;

}
