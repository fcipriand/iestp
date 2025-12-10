package com.example.hotel.controller;

import com.example.hotel.dto.DTOReservation;
import com.example.hotel.dto.DTODetailReservation;
import com.example.hotel.model.*;
import com.example.hotel.service.*;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/reservations")
@RequiredArgsConstructor
public class ReservationController {

    private final IReservationService reservationService;
    private final IClientService clientService;
    private final IRoomService roomService;

    @Qualifier("mapperDefault")
    private final ModelMapper mapper;

    // REGISTRAR RESERVA COMPLETA
    @PostMapping
    public ResponseEntity<DTOReservation> save(@Valid @RequestBody DTOReservation dto) throws Exception {

        // Obtener cliente
        Client client = clientService.findById(dto.getIdClient());

        // Convertir detalles usando programación funcional (STREAMS)
        List<DetailReservation> details = dto.getDetails()
                .stream()
                .map(this::convertDetail)
                .toList();

        Reservation reservation = new Reservation();
        reservation.setClient(client);
        reservation.setDateReservation(LocalDateTime.now());
        reservation.setDetails(details);
        reservation.setStatus(true);

        Reservation saved = reservationService.save(reservation);

        return new ResponseEntity<>(mapper.map(saved, DTOReservation.class),
                HttpStatus.CREATED);
    }

    // LISTAR
    @GetMapping
    public ResponseEntity<List<DTOReservation>> findAll() throws Exception {
        List<DTOReservation> list = reservationService.findAll()
                .stream()
                .map(r -> mapper.map(r, DTOReservation.class))
                .toList();

        return ResponseEntity.ok(list);
    }

    // ---------------------
    // MÉTODO UTILITARIO
    // ---------------------
    private DetailReservation convertDetail(DTODetailReservation dto) {
        DetailReservation detail = new DetailReservation();
        try {
            Room room = roomService.findById(dto.getIdRoom());

            detail.setRoom(room);
            detail.setCheckIn(dto.getCheckIn());
            detail.setCheckOut(dto.getCheckOut());

        } catch (Exception e) {
            throw new RuntimeException("Error in detail conversion: " + e.getMessage());
        }

        return detail;
    }
}
