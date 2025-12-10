package com.example.salud.service.impl;

import com.example.salud.model.Paciente;
import com.example.salud.repository.IGenericRepo;
import com.example.salud.repository.IPacienteRepo;
import com.example.salud.service.IPacienteService;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PacienteServiceImpl extends CRUDImpl<Paciente, Integer> implements IPacienteService {

    private final IPacienteRepo repo;

    @Override
    protected IGenericRepo<Paciente, Integer> getRepo() {
        return repo;
    }

	@Override
	public List<Paciente> findByNombres(String nombres) {
		// TODO Auto-generated method stub
		return repo.findByNombres(nombres);
	}

	@Override
	public List<Paciente> findByNombresLike(String nombres) {
		// TODO Auto-generated method stub
		return repo.findByNombresLike("%" + nombres + "%");
	}

	@Override
	public List<Paciente> findByNombresAndEdad(String nombres, Integer edad) {
		// TODO Auto-generated method stub
		return repo.findByNombresAndEdad(nombres, edad);
	}

	@Override
	public List<Paciente> listarPacientesOrdenadosEdadDesc() throws Exception {
		// TODO Auto-generated method stub
		return repo.listarPacientesOrdenadosEdadDesc();
	}



	
}

