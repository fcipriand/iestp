package iestp.edu.pe.controller;

import iestp.edu.pe.service.IVehicleService;
import iestp.edu.pe.dto.VehicleDTO;
import iestp.edu.pe.dto.VehicleDTO;
import iestp.edu.pe.model.Vehicle;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
@RequiredArgsConstructor
public class VehicleController {

    public final IVehicleService service;
    //public String next;
    @Qualifier("mapperDefault")
    public final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<VehicleDTO>>  findAll() throws Exception{

        List<VehicleDTO> list= service.findAll().stream().map(this::convertToDto).toList();
        //List<VehicleDTO> list= service.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleDTO> findById(@PathVariable("id") Integer id) throws Exception {
        Vehicle obj= service.findById(id);
       return new ResponseEntity<>(convertToDto(obj), HttpStatus.OK);
        //return ResponseEntity.ok(mapper.map(obj,VehicleDTO.class));
    }

    @PostMapping
    public ResponseEntity<VehicleDTO> save(@RequestBody VehicleDTO dto) throws Exception {
        Vehicle obj=  service.save(convertToEntity(dto));
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VehicleDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody VehicleDTO dto) throws Exception {
        Vehicle obj=  service.update(id, convertToEntity(dto));
        return ResponseEntity.ok(convertToDto(obj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@Valid @PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }


    /*Generar metodos utilitarios para mejorar el codigo*/
    //para convertir a DTO
    private VehicleDTO convertToDto(Vehicle obj){
        return mapper.map(obj,VehicleDTO.class);
    }
    //convertimos a entidad
    private Vehicle convertToEntity(VehicleDTO dto){
        return mapper.map(dto,Vehicle.class);
    }
}
