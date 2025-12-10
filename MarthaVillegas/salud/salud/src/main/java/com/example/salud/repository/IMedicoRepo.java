package com.example.salud.repository;

import java.util.List;

import com.example.salud.model.Medico;

public interface IMedicoRepo extends IGenericRepo<Medico, Integer> {
	
    // Métodos personalizados si fueran necesarios
	
	// Buscar por especialidad
    List<Medico> findByEspecialidad(String especialidad);
 // Buscar por nombre 
    List<Medico> findByNombres(String nombres);
    
 // Buscar por nombre que contenga texto
    List<Medico> findByNombresContaining(String texto);

}
