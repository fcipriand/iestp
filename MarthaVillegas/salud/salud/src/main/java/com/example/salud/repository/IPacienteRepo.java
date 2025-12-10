package com.example.salud.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;

import com.example.salud.model.Paciente;

public interface IPacienteRepo extends IGenericRepo<Paciente, Integer> {
    // Aquí puedes agregar métodos custom si deseas
	 // Derived Query
    List<Paciente> findByNombres(String nombres);
    List<Paciente> findByNombresLike(String nombres);
    List<Paciente> findByNombresAndEdad(String nombres, Integer edad);
    
    // Programación funcional (edad desc)
    //List<Paciente> listarPacientesOrdenadosEdadDesc() throws Exception;
    @Query("FROM Paciente p ORDER BY p.edad DESC")
    List<Paciente> listarPacientesOrdenadosEdadDesc();
    
   



}
