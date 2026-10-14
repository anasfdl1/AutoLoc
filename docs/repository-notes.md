# Atelier 3 — Couche Repository Spring Data JPA

## Choix des interfaces

Les neuf repositories sont placés dans
tn.esprit.autoloc.repository et étendent JpaRepository.
Le type Long correspond au type de la clé primaire des entités.

| Interface | Étend |
|---|---|
| IAgenceRepository | JpaRepository<Agence, Long> |
| IEmployeRepository | JpaRepository<Employe, Long> |
| IVehiculeRepository | JpaRepository<Vehicule, Long> |
| IEquipementRepository | JpaRepository<Equipement, Long> |
| IClientRepository | JpaRepository<Client, Long> |
| IReservationRepository | JpaRepository<Reservation, Long> |
| IContratRepository | JpaRepository<Contrat, Long> |
| IPaiementRepository | JpaRepository<Paiement, Long> |
| IMaintenanceRepository | JpaRepository<Maintenance, Long> |

JpaRepository fournit les opérations CRUD, des résultats sous
forme de List, le tri, la pagination et les méthodes flush
et saveAndFlush.

Spring Data génère les implémentations au démarrage :
aucune classe d’implémentation manuelle n’est nécessaire.

## Vérification du démarrage

La console indique :
- Found 9 JPA repository interfaces.
- Started AutolocApiApplication.

## Analyse SonarQube for IDE

Analyse du 14 octobre 2026 sur src/main/java :
- 25 fichiers Java analysés sur 25.
- 0 anomalie détectée.
- 0 Security Hotspot détecté.

Aucune correction issue de cette analyse n’a été nécessaire.
La consigne demandant trois anomalies corrigées n’a donc pas
pu être remplie sur cette version du code.

Ce résultat concerne les règles actives de l’outil et ne
garantit pas l’absence de tout défaut fonctionnel.

## Points à retenir

- save permet d’enregistrer ou de mettre à jour une entité.
- Utiliser l’objet retourné par save.
- findById retourne un Optional : l’entité peut être absente.
- Les suppressions JPA en lot contournent les cascades JPA
  et orphanRemoval.
- Les paiements sont créés ou retirés via leur contrat
  dans le code métier.
- ## Vérification des cascades

Les vérifications réalisées sur un contrat de démonstration
et deux paiements ont réussi :

- Cascade PERSIST : sauvegarder le contrat enregistre ses paiements.
- orphanRemoval : retirer un paiement de la collection du contrat
  le supprime en base.
- Cascade REMOVE : supprimer le contrat supprime le paiement restant.

Chaque résultat a été vérifié avec existsById().
La collection LAZY a été manipulée dans une transaction.
## Démonstration CRUD

Une démonstration exécutée avec CommandLineRunner crée un contrat
de test, le lit, modifie son montant de 500.00 à 750.00,
puis le supprime.

La modification est vérifiée par une nouvelle lecture en base.
La suppression est vérifiée avec existsById(), qui retourne false.

Les logs permettent d’observer INSERT, SELECT, UPDATE et DELETE.