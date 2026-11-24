package tn.esprit.autoloc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.service.IEmployeService;

import java.util.List;

@RestController
@RequestMapping("/employes")
@RequiredArgsConstructor
public class EmployeController {

    private final IEmployeService employeService;

    @PostMapping
    public Employe ajouterEmploye(@RequestBody Employe employe) {
        return employeService.create(employe);
    }

    @GetMapping
    public List<Employe> getAllEmployes() {
        return employeService.findAll();
    }

    @GetMapping("/{id}")
    public Employe getEmployeById(@PathVariable("id") Long id) {
        return employeService.findById(id);
    }

    @PutMapping("/{id}")
    public Employe updateEmploye(
            @PathVariable("id") Long id,
            @RequestBody Employe employe) {
        return employeService.update(id, employe);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployeById(@PathVariable("id") Long id) {
        employeService.deleteById(id);
    }
    @PutMapping("/desaffecterEmploye/{idEmploye}")
    public Employe desaffecterEmploye(@PathVariable Long idEmploye) {
        return employeService.desaffecterEmploye(idEmploye);
    }
    @PutMapping("/affecterAgence/{idEmploye}/{idAgence}")
    public Employe affecterAgence(
            @PathVariable("idEmploye") Long idEmploye,
            @PathVariable("idAgence") Long idAgence) {

        return employeService.affecterAgence(idEmploye, idAgence);
    }
}