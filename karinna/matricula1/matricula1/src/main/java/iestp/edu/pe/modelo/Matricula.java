package iestp.edu.pe.modelo;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

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
public class Matricula {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idMatricula;

	 @Column(nullable = false)
    private LocalDateTime fechaMatricula;

    @ManyToOne
    @JoinColumn(name = "id_estudiante",nullable = false,foreignKey = @ForeignKey(name = "FK_MATRICULA_ESTUDIANTE") )
    private Estudiante estudiante;
    
    @Column(nullable = false)
    private boolean estado;

    @OneToMany( mappedBy = "matricula",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<DetalleMatricula> detalleMatricula;

    
}
