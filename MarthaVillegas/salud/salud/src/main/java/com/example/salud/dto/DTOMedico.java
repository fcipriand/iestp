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
public class DTOMedico {

    private Integer idMedico;

    @NotNull
    @Size(min = 1, max = 50)
    private String nombres;

    @NotNull
    @Size(min = 1, max = 50)
    private String apellidos;

    @NotNull
    @Size(min = 1, max = 100)
    private String especialidad;

    @NotNull
    @Size(min = 3, max = 30)
    private String cmp;

    @NotNull
    private Boolean estado;
}
