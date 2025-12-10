package com.example.salud.service;

import java.util.List;

import com.example.salud.model.Paciente;

public interface IPacienteService extends ICRUD<Paciente, Integer> {
	
	// Derived Query
    List<Paciente> findByNombres(String nombres);
    List<Paciente> findByNombresLike(String nombres);
    List<Paciente> findByNombresAndEdad(String nombres, Integer edad);
    
    //  (edad desc)
    List<Paciente> listarPacientesOrdenadosEdadDesc() throws Exception;
}
