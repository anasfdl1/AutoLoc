package tn.esprit.autoloc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.service.IEquipementService;

import java.util.List;

@RestController
@RequestMapping("/equipements")
@RequiredArgsConstructor
public class EquipementController {

    private final IEquipementService equipementService;

    @PostMapping
    public Equipement ajouterEquipement(
            @RequestBody Equipement equipement) {
        return equipementService.create(equipement);
    }

    @GetMapping
    public List<Equipement> getAllEquipements() {
        return equipementService.findAll();
    }

    @GetMapping("/{id}")
    public Equipement getEquipementById(
            @PathVariable("id") Long id) {
        return equipementService.findById(id);
    }

    @PutMapping("/{id}")
    public Equipement updateEquipement(
            @PathVariable("id") Long id,
            @RequestBody Equipement equipement) {
        return equipementService.update(id, equipement);
    }

    @DeleteMapping("/{id}")
    public void deleteEquipementById(
            @PathVariable("id") Long id) {
        equipementService.deleteById(id);
    }
}