package com.example.salud.model;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCita;

    @Column(nullable = false)
    private LocalDateTime fechaCita;

    @ManyToOne
    @JoinColumn(name = "id_paciente", nullable = false)
    private Paciente paciente;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_cita")
    private List<DetalleCita> detalleCita;

    @Column(nullable = false)
    private Boolean estado;
}
