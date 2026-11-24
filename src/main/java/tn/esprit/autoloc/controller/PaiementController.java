package tn.esprit.autoloc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Paiement;
import tn.esprit.autoloc.service.IPaiementService;

import java.util.List;

@RestController
@RequestMapping("/paiements")
@RequiredArgsConstructor
public class PaiementController {

    private final IPaiementService paiementService;

    @GetMapping
    public List<Paiement> getAllPaiements() {
        return paiementService.findAll();
    }

    @GetMapping("/{id}")
    public Paiement getPaiementById(@PathVariable("id") Long id) {
        return paiementService.findById(id);
    }
}