package tn.esprit.autoloc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Reservation;
import tn.esprit.autoloc.service.IReservationService;

import java.util.List;

@RestController
@RequestMapping("/reservations")
@RequiredArgsConstructor
public class ReservationController {

    private final IReservationService reservationService;

    @PostMapping
    public Reservation ajouterReservation(
            @RequestBody Reservation reservation) {
        return reservationService.create(reservation);
    }

    @GetMapping
    public List<Reservation> getAllReservations() {
        return reservationService.findAll();
    }

    @GetMapping("/{id}")
    public Reservation getReservationById(
            @PathVariable("id") Long id) {
        return reservationService.findById(id);
    }

    @PutMapping("/{id}")
    public Reservation updateReservation(
            @PathVariable("id") Long id,
            @RequestBody Reservation reservation) {
        return reservationService.update(id, reservation);
    }

    @DeleteMapping("/{id}")
    public void deleteReservationById(
            @PathVariable("id") Long id) {
        reservationService.deleteById(id);
    }
}