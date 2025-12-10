package com.example.salud.service.impl;

import com.example.salud.model.Medico;
import com.example.salud.repository.IGenericRepo;
import com.example.salud.repository.IMedicoRepo;
import com.example.salud.service.IMedicoService;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MedicoServiceImpl extends CRUDImpl<Medico, Integer> implements IMedicoService {

    private final IMedicoRepo repo;

    @Override
    protected IGenericRepo<Medico, Integer> getRepo() {
        return repo;
    }
    
//
    
	@Override
	public List<Medico> buscarPorEspecialidad(String especialidad) {
		// TODO Auto-generated method stub
		return repo.findByEspecialidad(especialidad);
	}

	@Override
	public List<Medico> findByNombres(String nombres) {
		// TODO Auto-generated method stub
		return repo.findByNombres(nombres);
	}

	@Override
	public List<Medico> findByNombresContaining(String texto) {
		// TODO Auto-generated method stub
		return repo.findByNombresContaining(texto);
	}
}
