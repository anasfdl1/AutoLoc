package tn.esprit.autoloc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Contrat;
import tn.esprit.autoloc.service.IContratService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/contrats")
@Tag(name="gestion de contrats",description = "crud")
@RequiredArgsConstructor
public class ContratController {

    private final IContratService contratService;
    @Operation(summary = "ajouter un contrat ")
    @PostMapping
    public Contrat ajouterContrat(@RequestBody Contrat contrat) {
        return contratService.create(contrat);
    }

    @GetMapping
    public List<Contrat> getAllContrats() {
        return contratService.findAll();
    }

    @GetMapping("/{id}")
    public Contrat getContratById(@PathVariable("id") Long id) {
        return contratService.findById(id);
    }

    @PutMapping("/{id}")
    public Contrat updateContrat(
            @PathVariable("id") Long id,
            @RequestBody Contrat contrat) {
        return contratService.update(id, contrat);
    }

    @DeleteMapping("/{id}")
    public void deleteContratById(@PathVariable("id") Long id) {
        contratService.deleteById(id);
    }
}