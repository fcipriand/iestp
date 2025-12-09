package iestp.edu.pe.Service.impl;

import iestp.edu.pe.modelo.Estudiante;
import iestp.edu.pe.Repository.IEstudianteRepo;
import iestp.edu.pe.Repository.IGenericRepo;
import iestp.edu.pe.Service.IEstudianteService;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EstudianteService extends CRUDimpl<Estudiante, Integer> implements IEstudianteService {

    private final IEstudianteRepo repo;

    @Override
    protected IGenericRepo<Estudiante, Integer> getRepo() {
        return repo;
    }

	@Override
	public List<Estudiante> findByOrderByEdadDesc() {
		// TODO Auto-generated method stub
		return repo.findByOrderByEdadDesc();
	}

	

}
