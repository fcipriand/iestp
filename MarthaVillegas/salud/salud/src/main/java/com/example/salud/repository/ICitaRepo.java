package com.example.salud.repository;



import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.example.salud.model.Cita;

public interface ICitaRepo extends IGenericRepo<Cita, Integer> {
	 
    
    // Derived query Programación funcional con Map<K, V>
    @Query("SELECT c FROM Cita c JOIN FETCH c.paciente JOIN FETCH c.detalleCita d JOIN FETCH d.medico")
    List<Cita> listarCitasConTodo();
 
 // Derived Query: listar citas por ID de médico
    List<Cita> findByDetalleCita_Medico_IdMedico(Integer idMedico);
}
