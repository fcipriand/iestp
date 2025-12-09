package iestp.edu.pe.Repository;


import iestp.edu.pe.modelo.Estudiante;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

public interface IEstudianteRepo extends IGenericRepo<Estudiante,Integer> {

	List<Estudiante> findByOrderByEdadDesc();
	


}
