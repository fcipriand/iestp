package iestp.edu.pe.modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class DetalleMatricula {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idDetalleMatricula;
	
	@ManyToOne
	 @JsonBackReference
    @JoinColumn(name="id_matricula", nullable = false,foreignKey = @ForeignKey(name = "FK_DETAIL_MATRICULA"))
	private Matricula matricula;

    @ManyToOne
    @JoinColumn(name = "id_curso", nullable = false,foreignKey = @ForeignKey(name = "FK_DETALLE_CURSO"))
    private Curso curso;

    @Column(nullable = false, length = 20)
    private String aula;
}
