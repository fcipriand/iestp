package com.example.salud.service;

import java.util.List;

import com.example.salud.model.Medico;

public interface IMedicoService extends ICRUD<Medico, Integer> {
	// Funciones DeriveQuery
    List<Medico> buscarPorEspecialidad(String especialidad);
    
    List<Medico> findByNombres(String nombres);
    
    List<Medico> findByNombresContaining(String texto);
}