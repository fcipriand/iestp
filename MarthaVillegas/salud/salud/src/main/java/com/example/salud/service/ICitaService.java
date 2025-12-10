package com.example.salud.service;



import java.util.List;
import java.util.Map;

import com.example.salud.model.Cita;

public interface ICitaService extends ICRUD<Cita, Integer> {
	
	
	 // Programación funcional con Map<K, V>
    Map<String, List<String>> obtenerRelacionMedicoPacientes();
    
 // listar cita por id medico 
    List<Cita> findByDetalleCita_Medico_IdMedico(Integer idMedico);
}
