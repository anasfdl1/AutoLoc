package tn.esprit.autoloc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Maintenance;
import tn.esprit.autoloc.service.IMaintenanceService;

import java.util.List;

@RestController
@RequestMapping("/maintenances")
@RequiredArgsConstructor
public class MaintenanceController {

    private final IMaintenanceService maintenanceService;

    @PostMapping
    public Maintenance ajouterMaintenance(
            @RequestBody Maintenance maintenance) {
        return maintenanceService.create(maintenance);
    }

    @GetMapping
    public List<Maintenance> getAllMaintenances() {
        return maintenanceService.findAll();
    }

    @GetMapping("/{id}")
    public Maintenance getMaintenanceById(
            @PathVariable("id") Long id) {
        return maintenanceService.findById(id);
    }

    @PutMapping("/{id}")
    public Maintenance updateMaintenance(
            @PathVariable("id") Long id,
            @RequestBody Maintenance maintenance) {
        return maintenanceService.update(id, maintenance);
    }

    @DeleteMapping("/{id}")
    public void deleteMaintenanceById(
            @PathVariable("id") Long id) {
        maintenanceService.deleteById(id);
    }
}