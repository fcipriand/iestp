package com.example.hotel.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.*;
import lombok.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DTOReservation {

    private Integer id;

    @NotNull
    private Integer idClient;  // Id del cliente

    @NotNull
    @Size(min = 1)
    private List<DTODetailReservation> details; // Lista de detalles

    private Boolean status; // Estado (opcional al crear)
}
