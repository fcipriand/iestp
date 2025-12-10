package com.example.salud.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DTOCita {

    private Integer idCita;

    @NotNull(message = "Debe enviar la fecha")
    private LocalDateTime fechaCita;

    @NotNull(message = "Debe enviar el ID del paciente")
    private Integer idPaciente;

    @NotNull(message = "Debe enviar el detalle")
    private List<DTODetalleCita> detalle;

    @NotNull
    private Boolean estado;
}
