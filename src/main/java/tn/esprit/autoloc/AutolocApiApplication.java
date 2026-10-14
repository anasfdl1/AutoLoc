package tn.esprit.autoloc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tn.esprit.autoloc.domain.Contrat;
import tn.esprit.autoloc.repository.IContratRepository;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootApplication
public class AutolocApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutolocApiApplication.class, args);
    }

    @Bean
    CommandLineRunner demoContrat(IContratRepository contratRepository) {
        return args -> {
            contratRepository.findById(1L).ifPresentOrElse(
                    contrat -> {
                        contrat.setMontantTotal(new BigDecimal("750.00"));

                        Contrat contratModifie = contratRepository.save(contrat);

                        System.out.println("Contrat modifié : "
                                + contratModifie.getIdContrat());
                        System.out.println("Nouveau montant : "
                                + contratModifie.getMontantTotal());

                        contratRepository.findById(1L).ifPresent(
                                resultat -> System.out.println(
                                        "Montant relu en base : "
                                                + resultat.getMontantTotal()
                                )
                        );
                    },
                    () -> System.out.println("Aucun contrat avec cet identifiant.")
            );
        };