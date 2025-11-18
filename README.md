# 🏫 Application de Gestion des Absences - École Maternelle

Application web développée avec Spring Boot pour gérer les absences des étudiants d'une école maternelle.

## 📋 Description

Cette application permet de :
- Gérer les classes de l'école
- Gérer les étudiants et leur affectation aux classes
- Enregistrer et suivre les absences
- Rechercher et filtrer les données

## 🛠️ Technologies utilisées

- Backend : Spring Boot 3.x, Spring MVC, Spring Data JPA
- Frontend : Thymeleaf, Bootstrap 5
- Base de données : MySQL
- Build : Maven
- IDE : IntelliJ IDEA
  
## 📦 Architecture

L'application suit une architecture en couches (Layered Architecture) :
```
├── entities/         # Modèles de données (JPA)
├── repositories/     # Couche d'accès aux données
├── services/         # Logique métier
├── controllers/      # Contrôleurs Spring MVC
└── templates/        # Vues Thymeleaf
```
### 🪜 Étapes

1. Cloner le repository
```
git clone https://github.com/votre-username/gestion-absences.git
cd gestion-absences
```

2. Créer la base de données MySQL
```
CREATE DATABASE gestion_absences;
```

3. Configurer la connexion à la base de données

Modifier le fichier `src/main/resources/application.properties` :
```
spring.datasource.url=jdbc:mysql://localhost:3306/gestion_absences
spring.datasource.username=votre_username
spring.datasource.password=votre_password
```

4. Compiler et lancer l'application
```
mvn clean install
mvn spring-boot:run
```

5. Accéder à l'application
Ouvrir votre navigateur et aller sur : `http://localhost:8080`
