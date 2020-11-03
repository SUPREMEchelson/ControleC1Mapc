# Gestion de déploiement dans un Cloud

L'objectif de ce devoir est de créer un cadre logiciel (framework) pour décrire et gérer un déploiement de composants 
dans un Cloud (informatique en nuage. L'approche décrite dans ce contexte est proche du mode 
[Infrastructure as a service](https://en.wikipedia.org/wiki/Cloud_computing#Service_models).

## Consignes
Tous documents de cours autorisés, y compris la consultation sur l'Internet de documents
externes au cours.
## Concepts
Un Cloud est composé de ressources :

 - des noeuds de calcul (compute node) ;
 - des machines virtuelles (VM) déployées sur les compute node ;
 - des services hébergés dans les VM ;
 - des (instances de) composants implémentant ces services.
 
Les composants sont typés par les technologies qui les implantent.

Les VM sont déployées sur des **noeuds de calcul** (compute node) qui offrent des ressources en termes
de nombre de coeurs CPU et de mémoire (en Go). Chaque VM spécifie la quantité de ressources dont elle a besoin
(en nombre de coeurs CPU et mémoire), en fonction des besoins des instances de composants qu'elle héberge.

Chaque instance de composant peut spécifier la quantité de ressources dont elle a besoin,
si celle-ci diffère de celle spécifiée par défaut pour son type de composant.
Par exemple, une instance particulière d'apache requiert 2 CPU et 8 Go de mémoire, 
alors que ce type de composant requiert par défaut 1 CPU et 2 Go.


### Exemples
- Exemple de types de services : web server, application server, storage server, logging, monitoring

- Exemple de types de composants pour les services :

| web server | application server | storage server | logging | monitoring |
| ---------- | -------------------|--------------- |-------- |----------- | 
| apache     | tomcat             | mysql          | flume   | prometheus |
| nginx      | glassfish          | postgres       | fluentd | checkmk    |
| iis        | node.js            | mongodb        | rsyslog | zabbix     |


- Exemple de VM : freebsd-12.-i386, debian-10.6, centos-8.1, fedora-31, ubuntu-18.10.
 
### Contraintes et permissions
- P1 : un compute node peut accueillir plusieurs VM ; 
- P2 : une VM peut contenir plusieurs services du même type, mais de noms différents ;
- P3 : un Cloud peut contenir plusieurs compute node, sans limitation ; 
- C1 : un compute node ne peut pas accueillir de VM si les ressources sont insuffisantes 
pour satisfaire les quantités demandées ;
- C2 : pour un service d'un type donné, il ne peut y avoir au plus qu'une instance de composant implémentant ce service ;
- C3 : un compute node ne peut accueillir deux instances identiques de VM, c-à-d ayant
le même nom ;
- C4 : un type de composant est la donnée d'un nom et des ressources requises ;
- C5 : un composant est la donnée de son nom et du type de composant ;
- C6 : un service est la donnée de son nom, son type et le composant qui l'implémente ;
- C7 : une VM est la donnée de son nom, son OS et ses services  

## Exercice 1 - Création du diagramme de classe du logiciel

Écrivez le diagramme de classe de tout le logiciel qui vous est fourni.
Ce diagramme doit être au format de PlantUML (fichier PlantUML **et** image PNG ou SVG)

Lorsque des méthodes sont redéfinies, il faut les indiquer dans le diagramme
dans les classes qui les redéfinissent.

## Exercice 2 - Identification des patrons de conception et bonnes pratiques
Identifiez tous les patrons de conception et bonnes pratiques (SOLID, DRY, ...)
 mis en oeuvre dans le code, ainsi que les classes qui y participent.
 
 Proposez cette identification de la manière la plus structurée possible. 
 Par exemple, pour les patrons de conception, utilisez un tableau 
  où chaque colonne représente un patron identifié et chaque ligne
 les ensembles distincts de classes liées par ce patron.

## Exercice 3 - Visiteur par défaut
Implanter un visiteur par défaut qui affiche 
l'architecture d'un cloud (i.e. tous les éléments qui y déployés).
Vous pouvez par exemple réaliser cet affichage dans du HTML.
