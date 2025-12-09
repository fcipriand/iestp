package iestp.edu.pe.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import iestp.edu.pe.model.Client;
import iestp.edu.pe.model.RentalDetail;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RentalDTO {
	
	private Integer idRental;

    @NotNull
    private LocalDateTime rentalDate;

    @NotNull
    @JsonIncludeProperties({"idClient"})
    private ClientDTO client;

    @NotNull
    private Boolean status;

    @JsonManagedReference
    private List<RentalDetailDTO> details;

	 
}
