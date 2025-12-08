package iestp.edu.pe.model;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idRental;

    @Column(nullable = false)
    private LocalDateTime rentalDate; // FechaAlquiler

    @ManyToOne
    @JoinColumn(name="idClient", nullable = false,foreignKey = @ForeignKey(name = "FK_RENTAL_CLIENT"))
    private Client client; // Cliente

    @OneToMany(mappedBy = "rental", cascade = CascadeType.ALL)
    private List<RentalDetail> details; // DetalleAlquiler[]

    @Column(nullable = false)
    private Boolean status; // Estado
}
