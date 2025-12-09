package iestp.edu.pe.Service;

import java.util.List;

import iestp.edu.pe.modelo.Estudiante;

public interface IEstudianteService extends ICRUD<Estudiante, Integer> {
	
	List<Estudiante> findByOrderByEdadDesc();
	
	
	
	
	
	
	
	




}
