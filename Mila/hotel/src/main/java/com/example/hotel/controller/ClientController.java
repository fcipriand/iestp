package com.example.hotel.controller;

import com.example.hotel.dto.DTOClient;
import com.example.hotel.model.Client;
import com.example.hotel.service.IClientService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientController {

    private final IClientService service;

    @Qualifier("mapperDefault")
    private final ModelMapper mapper;

    // LISTAR
    @GetMapping
    public ResponseEntity<List<DTOClient>> findAll() throws Exception {
        List<DTOClient> list = service.findAll()
                .stream()
                .map(this::convertToDto)
                .toList();

        return ResponseEntity.ok(list);
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<DTOClient> findById(@PathVariable Integer id) throws Exception {
        Client obj = service.findById(id);
        return ResponseEntity.ok(convertToDto(obj));
    }

    // CREAR
    @PostMapping
    public ResponseEntity<DTOClient> save(@Valid @RequestBody DTOClient dto) throws Exception {
        Client obj = service.save(convertToEntity(dto));
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.CREATED);
    }

    // ACTUALIZAR
    @PutMapping("/{id}")
    public ResponseEntity<DTOClient> update(@Valid @PathVariable Integer id,
                                            @RequestBody DTOClient dto) throws Exception {
        Client obj = service.update(id, convertToEntity(dto));
        return ResponseEntity.ok(convertToDto(obj));
    }

    // ELIMINAR
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    // ----------------------
    // MÉTODOS UTILITARIOS
    // ----------------------

    private DTOClient convertToDto(Client obj) {
        return mapper.map(obj, DTOClient.class);
    }

    private Client convertToEntity(DTOClient dto) {
        return mapper.map(dto, Client.class);
    }
}
