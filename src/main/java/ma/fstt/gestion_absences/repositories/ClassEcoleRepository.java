package ma.fstt.gestion_absences.repositories;

import ma.fstt.gestion_absences.entities.ClasseEcole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassEcoleRepository extends JpaRepository<ClasseEcole, Long> {
    // Spring Data JPA génère automatiquement les méthodes crud

}