package com.example.hotel.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;   

    @Column(nullable = false)
    private LocalDateTime dateReservation; 

    @ManyToOne
    @JoinColumn(name = "id_client", nullable = false)
    private Client client; 

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_reservation")
    private List<DetailReservation> details; 

    private Boolean status; 
}
