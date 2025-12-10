package com.example.salud.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DTOPaciente {

    private Integer idPaciente;

    @NotNull
    @Size(min = 1, max = 50)
    private String nombres;

    @NotNull
    @Size(min = 1, max = 50)
    private String apellidos;

    @NotNull
    @Size(min = 8, max = 8, message = "El DNI debe tener 8 dígitos")
    private String dni;

    @NotNull
    @Min(0)
    @Max(120)
    private Integer edad;

    @Size(max = 150)
    private String direccion;
}
