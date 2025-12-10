package com.example.salud.service.impl;

import com.example.salud.model.Cita;

import com.example.salud.repository.ICitaRepo;
import com.example.salud.repository.IGenericRepo;
import com.example.salud.service.ICitaService;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CitaServiceImpl extends CRUDImpl<Cita, Integer> implements ICitaService {

    private final ICitaRepo repo;

    @Override
    protected IGenericRepo<Cita, Integer> getRepo() {
        return repo;
    }

    //obtener medico paciente 
    @Override
    public Map<String, List<String>> obtenerRelacionMedicoPacientes() {

        return repo.listarCitasConTodo()
                .stream()
                .collect(Collectors.groupingBy(

                        // KEY → Nombre del médico (con especialidad)
                        c -> c.getDetalleCita()
                              .get(0)  // la primera atención
                              .getMedico().getNombres() + " " +
                              c.getDetalleCita().get(0).getMedico().getApellidos() +
                              " (" + c.getDetalleCita().get(0).getMedico().getEspecialidad() + ")",

                        // VALUE → Nombres de los pacientes
                        Collectors.mapping(
                                c -> c.getPaciente().getNombres() + " " + c.getPaciente().getApellidos(),
                                Collectors.toList()
                        )
                ));
    }

	@Override
	public List<Cita> findByDetalleCita_Medico_IdMedico(Integer idMedico) {
		// TODO Auto-generated method stub
		return repo.findByDetalleCita_Medico_IdMedico(idMedico);
	}
    
    //listar citas  por id  medico

    
}
