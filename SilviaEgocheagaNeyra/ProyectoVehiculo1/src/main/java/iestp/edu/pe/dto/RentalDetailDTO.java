package iestp.edu.pe.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;

import iestp.edu.pe.model.Rental;
import iestp.edu.pe.model.Vehicle;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RentalDetailDTO {

    @NotNull
    @JsonBackReference
    private RentalDTO rental;

    @NotNull
    @JsonIncludeProperties({"idVehicle"})
    private VehicleDTO vehicle;

    @NotNull
    private LocalDate startDate;

    @NotNull
    private LocalDate endDate;

    @NotNull
    @Min(1)
    private Double price;
}
