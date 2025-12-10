package com.example.hotel.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;   

    @Column(nullable = false, length = 50)
    private String firstName;  

    @Column(nullable = false, length = 50)
    private String lastName;   

    @Column(nullable = false, unique = true, length = 10)
    private String dni;        

    @Column(length = 20)
    private String phone;      

    @Column(length = 150)
    private String email;      
}

