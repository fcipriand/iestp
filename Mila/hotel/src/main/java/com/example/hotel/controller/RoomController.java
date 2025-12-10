package com.example.hotel.controller;

import com.example.hotel.dto.DTORoom;
import com.example.hotel.model.Room;
import com.example.hotel.service.IRoomService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
@RequiredArgsConstructor
public class RoomController {

    private final IRoomService service;

    @Qualifier("mapperDefault")
    private final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<DTORoom>> findAll() throws Exception {
        List<DTORoom> list = service.findAll()
                .stream()
                .map(this::convertToDto)
                .toList();

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DTORoom> findById(@PathVariable Integer id) throws Exception {
        Room obj = service.findById(id);
        return ResponseEntity.ok(convertToDto(obj));
    }

    @PostMapping
    public ResponseEntity<DTORoom> save(@Valid @RequestBody DTORoom dto) throws Exception {
        Room obj = service.save(convertToEntity(dto));
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DTORoom> update(@PathVariable Integer id,
                                          @Valid @RequestBody DTORoom dto) throws Exception {
        Room obj = service.update(id, convertToEntity(dto));
        return ResponseEntity.ok(convertToDto(obj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    private DTORoom convertToDto(Room obj) {
        return mapper.map(obj, DTORoom.class);
    }

    private Room convertToEntity(DTORoom dto) {
        return mapper.map(dto, Room.class);
    }
}
