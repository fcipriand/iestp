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
public class DTODetalleCita {

    private Integer idDetalle;

    @NotNull(message = "Debe enviar el ID del médico")
    private Integer idMedico;

    @NotNull
    @Size(min = 1, max = 50)
    private String consultorio;

    @NotNull
    @Size(min = 1, max = 150)
    private String motivo;
}
