# Atelier 2 — Stratégies de chargement et cascades

Les associations utilisent FetchType.LAZY pour charger les données
liées à la demande et limiter les chargements inutiles.

| Association | Fetch | Cascade | Justification |
|---|---|---|---|
| Contrat → Paiement | LAZY | ALL + orphanRemoval | Les paiements dépendent du contrat. Supprimer le contrat supprime ses paiements. Retirer un paiement de la collection entraîne sa suppression en base. |
| Paiement → Contrat | LAZY | Aucune | Une opération sur un paiement ne doit pas supprimer son contrat. |
| Agence → Vehicule | LAZY | Aucune | Le véhicule possède un cycle de vie indépendant de l’agence. |
| Agence → Employe | LAZY | Aucune | Les opérations sur l’agence ne sont pas propagées aux employés. |
| Vehicule ↔ Equipement | LAZY | Aucune | Les équipements sont partagés. Les collections utilisent des Set pour éviter les doublons. |
| Client → Reservation | LAZY | PERSIST | Enregistrer un nouveau client permet de persister ses nouvelles réservations. |
| Reservation → Client | LAZY | Aucune | Les opérations sur une réservation ne sont pas propagées au client. |
| Reservation → Vehicule | LAZY | Aucune | Le véhicule existe indépendamment de la réservation. |
| Vehicule → Reservation | LAZY | Aucune | Les opérations sur le véhicule ne sont pas propagées aux réservations. |
| Reservation → Contrat | LAZY | ALL | Les opérations sur la réservation se propagent à son contrat, conformément au modèle demandé. |
| Contrat → Reservation | LAZY | Aucune | La cascade est définie du côté Reservation. |
| Vehicule → Maintenance | LAZY | PERSIST | Enregistrer un nouveau véhicule permet de persister ses nouvelles maintenances. |
| Maintenance → Vehicule | LAZY | Aucune | Une opération sur une maintenance ne doit pas supprimer le véhicule. |

## Cohérence des associations

mappedBy désigne l’attribut du côté propriétaire.
Pour enregistrer une relation bidirectionnelle, les deux côtés
doivent être renseignés dans le code.

## Vérification du démarrage

L’application démarre et Spring Data détecte neuf repositories.
Le démarrage seul ne valide pas les effets des cascades :
ceux-ci doivent être observés lors des opérations de persistance.