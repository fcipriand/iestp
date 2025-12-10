package com.example.salud.controller;

import com.example.salud.dto.DTOMedico;
import com.example.salud.model.Medico;
import com.example.salud.service.IMedicoService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
@RequiredArgsConstructor
public class MedicoController {

    public final IMedicoService service;
    @Qualifier("mapperDefault")
    public final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<DTOMedico>> findAll() throws Exception {
        List<DTOMedico> list = service.findAll().stream()
                .map(this::convertToDto)
                .toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DTOMedico> findById(@PathVariable("id") Integer id) throws Exception {
        return new ResponseEntity<>(convertToDto(service.findById(id)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DTOMedico> save(@Valid @RequestBody DTOMedico dto) throws Exception {
        Medico obj = service.save(convertToEntity(dto));
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DTOMedico> update(@Valid @PathVariable("id") Integer id,
                                            @RequestBody DTOMedico dto) throws Exception {
        Medico obj = service.update(id, convertToEntity(dto));
        return ResponseEntity.ok(convertToDto(obj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@Valid @PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    private DTOMedico convertToDto(Medico obj) {
        return mapper.map(obj, DTOMedico.class);
    }

    private Medico convertToEntity(DTOMedico dto) {
        return mapper.map(dto, Medico.class);
    }
    
    //     DERIVE QUERY
    
    @GetMapping("/especialidad/{especialidad}")
    public List<Medico> buscarPorEspecialidad(@PathVariable String especialidad) {
        return service.buscarPorEspecialidad(especialidad);
    }
    
    @GetMapping("/nombres/{nombres}")
    public ResponseEntity<List<Medico>> buscarPorNombres(@PathVariable String nombres) {
        return ResponseEntity.ok(service.findByNombres(nombres));
    }
    
    
    @GetMapping("/buscar/{texto}")
    public ResponseEntity<List<Medico>> buscarPorNombreConteniendo(@PathVariable String texto) {
        return ResponseEntity.ok(service.findByNombresContaining(texto));
    }

}
