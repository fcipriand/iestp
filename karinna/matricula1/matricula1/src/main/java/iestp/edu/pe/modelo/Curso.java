package iestp.edu.pe.modelo;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import jakarta.persistence.OneToMany;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idCurso;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(nullable = false, length = 10)
    private String siglas;

    @Column(nullable = false)
    private boolean estado;
    
    
    @OneToMany(mappedBy = "curso")
    private List<DetalleMatricula> detalles;


}
