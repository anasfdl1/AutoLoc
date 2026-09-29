# AutoLoc

## Présentation

**AutoLoc** est une application de gestion de location de véhicules destinée à un environnement multi-agences.

Le projet a pour objectif de centraliser la gestion des véhicules, des clients, des réservations et des agences au sein d'une même plateforme.

L'application permet de structurer les principales opérations liées à la location de véhicules tout en facilitant le suivi des ressources et des utilisateurs.

## Fonctionnalités principales

- Gestion des agences
- Gestion des véhicules
- Gestion des clients
- Gestion des réservations
- Gestion des contrats de location
- Gestion des paiements
- Gestion des opérations de maintenance
- Gestion des équipements associés aux véhicules

## Acteurs du système

### Client
Le client peut consulter les véhicules disponibles et effectuer une demande de réservation ou de location.

### Agent d'agence
L'agent assure la gestion quotidienne des opérations de location au sein de son agence.

### Responsable d'agence
Le responsable supervise les activités de l'agence, les véhicules et les ressources associées.

### Administrateur
L'administrateur assure la gestion globale de la plateforme, des agences et des utilisateurs.

## Technologies utilisées

- Java 17
- Spring Boot
- Maven
- Spring Data JPA
- Hibernate
- MySQL
- Lombok
- IntelliJ IDEA
- XAMPP / phpMyAdmin
- Git / GitHub

## Structure du projet

Le projet suit une architecture Spring Boot organisée autour de plusieurs packages :

```text
tn.esprit.autoloc
├── domain
├── repository
├── service
└── web
    ├── controller
    └── dto
