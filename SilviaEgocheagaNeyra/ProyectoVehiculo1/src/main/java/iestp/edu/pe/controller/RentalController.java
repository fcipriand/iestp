package iestp.edu.pe.controller;

import iestp.edu.pe.service.IRentalService;
import iestp.edu.pe.dto.RentalDTO;
import iestp.edu.pe.model.Rental;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import jakarta.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/rentals")
@RequiredArgsConstructor
public class RentalController {

    public final IRentalService service;
    //public String next;
    @Qualifier("mapperDefault")
    public final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<RentalDTO>>  findAll() throws Exception{

        List<RentalDTO> list= service.findAll().stream().map(this::convertToDto).toList();
        //List<RentalDTO> list= service.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RentalDTO> findById(@PathVariable("id") Integer id) throws Exception {
        Rental obj= service.findById(id);
       return new ResponseEntity<>(convertToDto(obj), HttpStatus.OK);
        //return ResponseEntity.ok(mapper.map(obj,RentalDTO.class));
    }

    @PostMapping
    public ResponseEntity<RentalDTO> save(@RequestBody RentalDTO dto) throws Exception {
    	Rental rental = convertToEntity(dto);
        rental.getDetails().forEach(d -> d.setRental(rental));

        Rental saved = service.save(rental);

        return new ResponseEntity<>(convertToDto(saved), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RentalDTO> update(@Validated @PathVariable("id") Integer id, @RequestBody RentalDTO dto) throws Exception {
    	Rental rental = convertToEntity(dto);
        rental.getDetails().forEach(d -> d.setRental(rental)); 
        Rental obj = service.update(id, rental);
        return ResponseEntity.ok(convertToDto(obj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@Valid @PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }


    /*Generar metodos utilitarios para mejorar el codigo*/
    //para convertir a DTO
    private RentalDTO convertToDto(Rental obj){
        return mapper.map(obj,RentalDTO.class);
    }
    //convertimos a entidad
    private Rental convertToEntity(RentalDTO dto){
        return mapper.map(dto,Rental.class);
    }
    
    //PROGRAMACION FUNCIONAL
    @GetMapping("/vehicles-with-clients")
    public ResponseEntity<Map<String, List<String>>> getVehiclesWithClients() throws Exception {
        Map<String, List<String>> data = service.getVehiclesWithClients();
        return ResponseEntity.ok(data);
    }

}
