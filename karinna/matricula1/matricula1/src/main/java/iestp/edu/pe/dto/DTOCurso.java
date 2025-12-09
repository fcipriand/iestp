package iestp.edu.pe.dto;

import jakarta.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DTOCurso {

   
    private Integer idCurso;
    @NotNull
    @Size(min = 1, max = 50)
    private String nombre;

    @NotNull
    @Size(min = 1, max = 10)
    private String siglas;


    @NotNull
    private boolean estado;
}

