package iestp.edu.pe.controller;

import iestp.edu.pe.service.IClientService;
import iestp.edu.pe.dto.ClientDTO;
import iestp.edu.pe.dto.ClientDTO;
import iestp.edu.pe.model.Client;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import jakarta.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {

    public final IClientService service;
    //public String next;
    @Qualifier("mapperDefault")
    public final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<ClientDTO>>  findAll() throws Exception{

        List<ClientDTO> list= service.findAll().stream().map(this::convertToDto).toList();
        //List<ClientDTO> list= service.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> findById(@PathVariable("id") Integer id) throws Exception {
        Client obj= service.findById(id);
       return new ResponseEntity<>(convertToDto(obj), HttpStatus.OK);
        //return ResponseEntity.ok(mapper.map(obj,ClientDTO.class));
    }

    @PostMapping
    public ResponseEntity<ClientDTO> save(@RequestBody ClientDTO dto) throws Exception {
        Client obj=  service.save(convertToEntity(dto));
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientDTO> update(@Validated @PathVariable("id") Integer id, @RequestBody ClientDTO dto) throws Exception {
        Client obj=  service.update(id, convertToEntity(dto));
        return ResponseEntity.ok(convertToDto(obj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@Valid @PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }


    /*Generar metodos utilitarios para mejorar el codigo*/
    //para convertir a DTO
    private ClientDTO convertToDto(Client obj){
        return mapper.map(obj,ClientDTO.class);
    }
    //convertimos a entidad
    private Client convertToEntity(ClientDTO dto){
        return mapper.map(dto,Client.class);
    }
    
    
    // PROGRAMACION FUNCIONAL 
    
    
    @GetMapping("/sorted")
    public ResponseEntity<List<ClientDTO>> findBylastName() throws Exception {

        List<ClientDTO> list = service.findAll()
                .stream()
                .sorted(Comparator.comparing(Client::getLastName))
                .map(this::convertToDto)
                .toList();

        return ResponseEntity.ok(list);
    }


}
