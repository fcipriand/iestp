package com.example.salud.controller;

import com.example.salud.dto.DTOCita;


import com.example.salud.model.Cita;
import com.example.salud.service.ICitaService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/citas")
@RequiredArgsConstructor
public class CitaController {

    public final ICitaService service;
    @Qualifier("mapperDefault")
    public final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<DTOCita>> findAll() throws Exception {
        List<DTOCita> list = service.findAll().stream()
                .map(this::convertToDto)
                .toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DTOCita> findById(@PathVariable("id") Integer id) throws Exception {
        return new ResponseEntity<>(convertToDto(service.findById(id)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DTOCita> save(@Valid @RequestBody DTOCita dto) throws Exception {
        Cita obj = service.save(convertToEntity(dto));
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DTOCita> update(@Valid @PathVariable("id") Integer id,
                                          @RequestBody DTOCita dto) throws Exception {
        Cita obj = service.update(id, convertToEntity(dto));
        return ResponseEntity.ok(convertToDto(obj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@Valid @PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    private DTOCita convertToDto(Cita obj) {
        return mapper.map(obj, DTOCita.class);
    }

    private Cita convertToEntity(DTOCita dto) {
        return mapper.map(dto, Cita.class);
    }
  
    
    @GetMapping("/relacion-medico-pacientes")
    public ResponseEntity<Map<String, List<String>>> relacionMedicoPacientes() {
        return ResponseEntity.ok(service.obtenerRelacionMedicoPacientes());
    }
    
 // Listar citas por ID de médico
    @GetMapping("/medico/{idMedico}")
    public ResponseEntity<List<Cita>> listarPorMedico(@PathVariable Integer idMedico) {
        return ResponseEntity.ok(service.findByDetalleCita_Medico_IdMedico(idMedico));
    }

}
