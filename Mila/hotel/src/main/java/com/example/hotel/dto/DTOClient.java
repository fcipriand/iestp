package com.example.hotel.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DTOClient {

    private Integer id;

    @NotBlank
    @Size(min = 1, max = 50)
    private String firstName;   

    @NotBlank
    @Size(min = 1, max = 50)
    private String lastName;    

    @NotBlank
    @Size(min = 8, max = 8)
    private String dni;         

    @Size(max = 9)
    private String phone;      

    @Email
    @Size(max = 150)
    private String email;      
}
