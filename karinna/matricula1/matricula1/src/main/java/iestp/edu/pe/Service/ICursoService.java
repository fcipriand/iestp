package iestp.edu.pe.Service;
import java.util.Map;
import java.util.List;

import iestp.edu.pe.modelo.Curso;

public interface ICursoService extends ICRUD<Curso, Integer> {
	Map<String, List<String>> getcursosWithEstuden();


}
