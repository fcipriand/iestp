package com.example.hotel.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DTORoom {

    private Integer id;

    @NotBlank
    @Size(min = 1, max = 10)
    private String number;   

    @NotBlank
    @Size(min = 3, max = 20)
    private String type;     

    @NotNull
    @Positive
    private Double price;    

    @NotNull
    private Boolean available; 
}
