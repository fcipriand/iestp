package iestp.edu.pe.Controller;

import iestp.edu.pe.Service.IMatriculaService;
import iestp.edu.pe.dto.DTOMatricula;
import iestp.edu.pe.modelo.Matricula;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matriculas")
@RequiredArgsConstructor
public class MatriculaController {

    private final IMatriculaService service;

    @Qualifier("defaultMapper")
    private final ModelMapper mapper;
    

    @GetMapping
    public ResponseEntity<List<DTOMatricula>> findAll() throws Exception {
        List<DTOMatricula> list = service.findAll()
                .stream()
                .map(this::convertToDto)
                .toList();

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DTOMatricula> findById(@PathVariable("id") Integer id) throws Exception {
        Matricula obj = service.findById(id);
        return ResponseEntity.ok(convertToDto(obj));
    }

    @PostMapping
    public ResponseEntity<DTOMatricula> save(@Valid @RequestBody DTOMatricula dto) throws Exception {
    	 Matricula entity = convertToEntity(dto);

    	    Matricula obj = service.save(entity);
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DTOMatricula> update(@Valid @PathVariable("id") Integer id,
                                                @RequestBody DTOMatricula dto) throws Exception {
        Matricula obj = service.update(id, convertToEntity(dto));
        return ResponseEntity.ok(convertToDto(obj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    // Métodos utilitarios
    private DTOMatricula convertToDto(Matricula obj) {
        return mapper.map(obj, DTOMatricula.class);
    }

    private Matricula convertToEntity(DTOMatricula dto) {
    	Matricula entity = mapper.map(dto, Matricula.class);

        if(entity.getDetalleMatricula() != null){
            entity.getDetalleMatricula().forEach(d -> d.setMatricula(entity));
        }
        return entity;
    }
}


