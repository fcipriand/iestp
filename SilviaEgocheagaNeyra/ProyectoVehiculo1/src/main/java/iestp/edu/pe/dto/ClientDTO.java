package iestp.edu.pe.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {
	
	    private Integer idClient;

	    @Size(min = 1, max = 20)
	    private String firstName;
	    
	    @Size(min = 1, max = 20)
	    private String lastName;

	    @Size(min = 1, max = 10)
	    private String dni;
	    
	    @Size(min = 1, max = 10)
	    private String phone;

	    @Column(name = "driver_license")
	    private String driverLicense;
}
