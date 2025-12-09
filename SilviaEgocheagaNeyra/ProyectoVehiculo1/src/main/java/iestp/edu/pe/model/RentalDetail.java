package iestp.edu.pe.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class RentalDetail {

	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @EqualsAndHashCode.Include
	    private Integer idRentalDetail;

	    @ManyToOne
	    @JoinColumn(name="id_vehicle", nullable = false,foreignKey = @ForeignKey(name = "FK_DETAIL_VEHICLE"))
	    private Vehicle vehicle;

	    @ManyToOne
	    @JoinColumn(name="id_rental", nullable = false,foreignKey = @ForeignKey(name = "FK_DETAIL_RENTAL"))
	    private Rental rental;
	    
	    @Column(nullable = false)
	    private LocalDate startDate;

	    @Column(nullable = false)
	    private LocalDate endDate;

	    @Column(nullable = false, columnDefinition = "decimal(6,2)")//9999,99
	    private Double price;

}
