package iestp.edu.pe.Controller;

import iestp.edu.pe.Service.ICursoService;
import iestp.edu.pe.dto.DTOCurso;
import iestp.edu.pe.modelo.Curso;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
@RequiredArgsConstructor
public class CursoController {

    private final ICursoService service;

    private final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<DTOCurso>> findAll() throws Exception {
        List<DTOCurso> list = service.findAll()
                .stream()
                .map(this::convertToDto)
                .toList();

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DTOCurso> findById(@PathVariable("id") Integer id) throws Exception {
        Curso obj = service.findById(id);
        return ResponseEntity.ok(convertToDto(obj));
    }

    @PostMapping
    public ResponseEntity<DTOCurso> save(@Valid @RequestBody DTOCurso dto) throws Exception {
        Curso obj = service.save(convertToEntity(dto));
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DTOCurso> update(@Valid @PathVariable("id") Integer id,
    		@Valid  @RequestBody DTOCurso dto) throws Exception {
        Curso obj = service.update(id, convertToEntity(dto));
        return ResponseEntity.ok(convertToDto(obj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@Valid @PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    // Métodos utilitarios
    private DTOCurso convertToDto(Curso obj) {
        return mapper.map(obj, DTOCurso.class);
    }

    private Curso convertToEntity(DTOCurso dto) {
        return mapper.map(dto, Curso.class);
    }
    
    // NUEVO ENDPOINT
    @GetMapping("/cursos-with-estudiantes")
    public ResponseEntity<Map<String, List<String>>> getCursosWithEstudiantes() throws Exception {
        Map<String, List<String>> data = service.getcursosWithEstuden();
        return ResponseEntity.ok(data);
    }

}


