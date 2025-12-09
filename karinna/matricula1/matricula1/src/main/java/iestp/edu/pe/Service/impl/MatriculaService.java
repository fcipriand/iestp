package iestp.edu.pe.Service.impl;

import iestp.edu.pe.modelo.Matricula;
import iestp.edu.pe.Repository.IMatriculaRepo;
import iestp.edu.pe.Repository.IGenericRepo;
import iestp.edu.pe.Service.IMatriculaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MatriculaService extends CRUDimpl<Matricula, Integer> implements IMatriculaService {

    private final IMatriculaRepo repo;

    @Override
    protected IGenericRepo<Matricula, Integer> getRepo() {
        return repo;
    }
}
