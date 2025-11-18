

package ma.fstt.gestion_absences.repositories;
import ma.fstt.gestion_absences.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    // Méthodes personnalisées utiles
    List<Student> findByClasseId(Long classeId);
    List<Student> findByNomContainingIgnoreCase(String nom);
}