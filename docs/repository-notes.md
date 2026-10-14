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