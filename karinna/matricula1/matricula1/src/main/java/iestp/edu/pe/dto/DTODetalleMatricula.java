package iestp.edu.pe.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DTODetalleMatricula {
    @NotNull
	@JsonBackReference
	@JsonIgnore
    private DTOMatricula matricula;

	@NotNull
	@JsonIncludeProperties(value = {"idCurso"})
    private DTOCurso curso;

    @NotNull
    private String aula;
}

