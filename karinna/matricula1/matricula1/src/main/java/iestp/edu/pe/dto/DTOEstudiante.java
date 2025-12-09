package iestp.edu.pe.dto;

import org.antlr.v4.runtime.misc.NotNull;
import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DTOEstudiante {

    private Integer idEstudiante;

    @NotNull
    @Size(min = 1, max = 50)
    private String nombres;

    @NotNull
    @Size(min = 1, max = 50)
    private String apellidos;

    @NotNull
    @Size(min = 8, max = 8)
    private String dni;

    @NotNull
    private Integer edad;
}

