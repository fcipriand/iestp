package iestp.edu.pe.Service.impl;

import iestp.edu.pe.modelo.Curso;
import iestp.edu.pe.Repository.ICursoRepo;
import iestp.edu.pe.Repository.IEstudianteRepo;
import iestp.edu.pe.Repository.IGenericRepo;
import iestp.edu.pe.Service.ICursoService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CursoService extends CRUDimpl<Curso, Integer> implements ICursoService {

    private final ICursoRepo repo;
    private final IEstudianteRepo estudianteRepo;


    @Override
    protected IGenericRepo<Curso, Integer> getRepo() {
        return repo;
    }
    
    @Override
    public Map<String, List<String>> getcursosWithEstuden() {
        return repo.findAll().stream()
                .flatMap(curso -> curso.getDetalles().stream())
                .collect(Collectors.groupingBy(
                        detalle -> detalle.getCurso().getNombre(),
                        Collectors.mapping(
                                detalle -> detalle.getMatricula().getEstudiante().getNombres() + " " +
                                           detalle.getMatricula().getEstudiante().getApellidos(),
                                Collectors.toList()
                        )
                ));
    }


    
}
  

