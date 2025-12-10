package com.example.hotel.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class DetailReservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;   

    @ManyToOne
    @JoinColumn(name = "id_room", nullable = false)
    private Room room;  

    @Column(nullable = false)
    private LocalDate checkIn;  // FechaEntrada

    @Column(nullable = false)
    private LocalDate checkOut; // FechaSalida
}
