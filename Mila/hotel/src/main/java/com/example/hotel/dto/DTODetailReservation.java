package com.example.hotel.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DTODetailReservation {

    private Integer id;

    @NotNull
    private Integer idRoom;     

    @NotNull
    private LocalDate checkIn;  

    @NotNull
    private LocalDate checkOut; 
}
