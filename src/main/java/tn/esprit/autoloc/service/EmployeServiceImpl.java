package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.exception.ResourceNotFoundException;
import tn.esprit.autoloc.repository.IEmployeRepository;
import tn.esprit.autoloc.repository.IAgenceRepository;
import tn.esprit.autoloc.domain.Agence;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeServiceImpl implements IEmployeService {

    private final IEmployeRepository employeRepository;
    private final IAgenceRepository agenceRepository;

    @Override
    public Employe create(Employe employe) {
        if (employe.getIdEmploye() != null) {
            throw new IllegalArgumentException(
                    "Un nouvel employé ne doit pas avoir d'identifiant.");
        }

        verifierEmploye(employe);
        return employeRepository.save(employe);
    }

    @Override
    public Employe findById(Long id) {
        return employeRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employé", id));
    }

    @Override
    public List<Employe> findAll() {
        return employeRepository.findAll();
    }

    @Override
    public Employe update(Long id, Employe employe) {
        Employe existant = findById(id);
        verifierEmploye(employe);

        existant.setNom(employe.getNom());
        existant.setPrenom(employe.getPrenom());
        existant.setRole(employe.getRole());

        return employeRepository.save(existant);
    }

    @Override
    public void deleteById(Long id) {
        if (!employeRepository.existsById(id)) {
            throw new ResourceNotFoundException("Employé", id);
        }

        employeRepository.deleteById(id);
    }

    @Override
    public Employe desaffecterEmploye(Long idEmploye) {
        Employe e =employeRepository.findById(idEmploye).get();
        e.setAgence(null);
        return employeRepository.save(e);
    }

    private void verifierEmploye(Employe employe) {
        if (employe.getNom() == null || employe.getNom().isBlank()) {
            throw new IllegalArgumentException(
                    "Le nom de l'employé est obligatoire.");
        }

        if (employe.getRole() == null) {
            throw new IllegalArgumentException(
                    "Le rôle de l'employé est obligatoire.");
        }
    }
    @Override
    public Employe affecterAgence(Long idEmploye, Long idAgence) {
        Employe e = employeRepository.findById(idEmploye).get();
        Agence a = agenceRepository.findById(idAgence).get();
        e.setAgence(a);
        return employeRepository.save(e);
    }
}