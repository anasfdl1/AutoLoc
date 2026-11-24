package tn.esprit.autoloc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.service.IVehiculeService;

import java.util.List;

@RestController
@RequestMapping("/vehicules")
@RequiredArgsConstructor
public class VehiculeController {

    private final IVehiculeService vehiculeService;

    @PostMapping
    public Vehicule ajouterVehicule(@RequestBody Vehicule vehicule) {
        return vehiculeService.create(vehicule);
    }

    @PutMapping("/{id}")
    public Vehicule updateVehicule(@PathVariable("id") Long id,
                                   @RequestBody Vehicule vehicule) {
        return vehiculeService.update(id, vehicule);
    }
    @GetMapping
    public List<Vehicule> getAllVehicules() {
        return vehiculeService.findAll();
    }

    @GetMapping("/{id}")
    public Vehicule getVehiculeById(@PathVariable("id") Long id) {
        return vehiculeService.findById(id);
    }
    @DeleteMapping("/{id}")
    public void deleteVehiculeById(@PathVariable("id") Long id) {
        vehiculeService.deleteById(id);
    }
    @PutMapping("/affecterEquipement/{idVehicule}/{idEquipement}")
    public Vehicule affecterEquipement(
            @PathVariable("idVehicule") Long idVehicule,
            @PathVariable("idEquipement") Long idEquipement) {

        return vehiculeService.affecterEquipement(idVehicule, idEquipement);
    }

    @PutMapping("/desaffecterEquipement/{idVehicule}/{idEquipement}")
    public Vehicule desaffecterEquipement(
            @PathVariable("idVehicule") Long idVehicule,
            @PathVariable("idEquipement") Long idEquipement) {

        return vehiculeService.desaffecterEquipement(idVehicule, idEquipement);
    }
}