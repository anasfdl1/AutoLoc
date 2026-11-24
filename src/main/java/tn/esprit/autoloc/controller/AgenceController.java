package tn.esprit.autoloc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.service.IAgenceService;

import java.util.List;

@RestController
@RequestMapping("/agences")
@RequiredArgsConstructor
public class AgenceController {

    private final IAgenceService agenceService;

    @PostMapping
    public Agence ajouterAgence(@RequestBody Agence agence) {
        return agenceService.create(agence);
    }

    @GetMapping
    public List<Agence> getAllAgences() {
        return agenceService.findAll();
    }

    @GetMapping("/{id}")
    public Agence getAgenceById(@PathVariable("id") Long id) {
        return agenceService.findById(id);
    }

    @PutMapping("/{id}")
    public Agence updateAgence(
            @PathVariable("id") Long id,
            @RequestBody Agence agence) {
        return agenceService.update(id, agence);
    }

    @DeleteMapping("/{id}")
    public void deleteAgenceById(@PathVariable("id") Long id) {
        agenceService.deleteById(id);
    }
    @PostMapping("/ajouterAgenceEtAffecterVehicules")
    public Agence ajouterAgenceEtAffecterVehicules(
            @RequestBody Agence agence) {

        return agenceService.ajouterAgenceEtAffecterVehicules(agence);
    }
}