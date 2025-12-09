package iestp.edu.pe.Controller;

import iestp.edu.pe.Service.IEstudianteService;
import iestp.edu.pe.dto.DTOEstudiante;
import iestp.edu.pe.modelo.Estudiante;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudiantes")
@RequiredArgsConstructor
public class EstudianteController {

    private final IEstudianteService service;

    private final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<DTOEstudiante>> findAll() throws Exception {
        List<DTOEstudiante> list = service.findAll()
                .stream()
                .map(this::convertToDto)
                .toList();

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DTOEstudiante> findById(@PathVariable("id") Integer id) throws Exception {
        Estudiante obj = service.findById(id);
        return ResponseEntity.ok(convertToDto(obj));
    }

    @PostMapping
    public ResponseEntity<DTOEstudiante> save(@Valid @RequestBody DTOEstudiante dto) throws Exception {
        Estudiante obj = service.save(convertToEntity(dto));
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DTOEstudiante> update(@Valid @PathVariable("id") Integer id,
                                                @RequestBody DTOEstudiante dto) throws Exception {
        Estudiante obj = service.update(id, convertToEntity(dto));
        return ResponseEntity.ok(convertToDto(obj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@Valid @PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    // Métodos utilitarios
    private DTOEstudiante convertToDto(Estudiante obj) {
        return mapper.map(obj, DTOEstudiante.class);
    }

    private Estudiante convertToEntity(DTOEstudiante dto) {
        return mapper.map(dto, Estudiante.class);
    }
    
    
    @GetMapping("/edad/desc")
    public ResponseEntity<List<DTOEstudiante>> listarPorEdadDesc() throws Exception {
        List<DTOEstudiante> lista = service.findByOrderByEdadDesc().stream().map(this::convertToDto).toList();
        return ResponseEntity.ok(lista);
    }
   

}
   



