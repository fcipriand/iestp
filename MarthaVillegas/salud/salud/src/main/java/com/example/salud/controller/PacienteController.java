package com.example.salud.controller;

import com.example.salud.dto.DTOPaciente;
import com.example.salud.model.Paciente;
import com.example.salud.service.IPacienteService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
@RequiredArgsConstructor
public class PacienteController {

    public final IPacienteService service;
    @Qualifier("mapperDefault")
    public final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<DTOPaciente>> findAll() throws Exception {
        List<DTOPaciente> list = service.findAll().stream()
                .map(this::convertToDto)
                .toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DTOPaciente> findById(@PathVariable("id") Integer id) throws Exception {
        return new ResponseEntity<>(convertToDto(service.findById(id)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DTOPaciente> save(@Valid @RequestBody DTOPaciente dto) throws Exception {
        Paciente obj = service.save(convertToEntity(dto));
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DTOPaciente> update(@Valid @PathVariable("id") Integer id,
                                              @RequestBody DTOPaciente dto) throws Exception {
        Paciente obj = service.update(id, convertToEntity(dto));
        return ResponseEntity.ok(convertToDto(obj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@Valid @PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    private DTOPaciente convertToDto(Paciente obj) {
        return mapper.map(obj, DTOPaciente.class);
    }

    private Paciente convertToEntity(DTOPaciente dto) {
        return mapper.map(dto, Paciente.class);
    }
    
    // 
    @GetMapping("/find/nombres/{nombres}")
    public ResponseEntity<List<DTOPaciente>> findByNombres(@PathVariable("nombres") String nombres) throws Exception {
        List<DTOPaciente> list =
                service.findByNombres(nombres).stream()
                        .map(this::convertToDto)
                        .toList();
        return ResponseEntity.ok(list);
    }
    
    @GetMapping("/find/nombres/like/{nombres}")
    public ResponseEntity<List<DTOPaciente>> findByNombresLike(@PathVariable("nombres") String nombres) throws Exception {
        List<DTOPaciente> list =
                service.findByNombresLike(nombres).stream()
                        .map(this::convertToDto)
                        .toList();
        return ResponseEntity.ok(list);
    }
    
    @GetMapping("/find/nombres/edad")
    public ResponseEntity<List<DTOPaciente>> findByNombresAndEdad(
            @RequestParam("nombres") String nombres,
            @RequestParam("edad") Integer edad) throws Exception {

        List<DTOPaciente> list =
                service.findByNombresAndEdad(nombres, edad).stream()
                        .map(this::convertToDto)
                        .toList();
        return ResponseEntity.ok(list);
    }
    @GetMapping("/ordenado/edad-desc")
    public ResponseEntity<List<DTOPaciente>> listarPacientesEdadDesc() throws Exception {
        List<DTOPaciente> list =
                service.listarPacientesOrdenadosEdadDesc()
                       .stream()
                       .map(this::convertToDto)
                       .toList();
        return ResponseEntity.ok(list);
    }

    
    
}
