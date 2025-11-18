package ma.fstt.gestion_absences.repositories;


import ma.fstt.gestion_absences.entities.Absence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface AbsenceRepository extends JpaRepository<Absence, Long> {
    // Méthodes personnalisées utiles
    List<Absence> findByStudentId(Long studentId);
    List<Absence> findByDate(LocalDate date);
    List<Absence> findByDateBetween(LocalDate startDate, LocalDate endDate);
}