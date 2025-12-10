package com.example.hotel.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;    

    @Column(nullable = false, length = 10)
    private String number;   

    @Column(nullable = false, length = 20)
    private String type;     

    @Column(nullable = false)
    private Double price;    

    @Column(nullable = false)
    private Boolean available;  
}
