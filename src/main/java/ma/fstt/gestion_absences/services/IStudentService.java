package ma.fstt.gestion_absences.services;
import ma.fstt.gestion_absences.entities.Student;
import java.util.List;

public interface IStudentService {
    Student saveStudent(Student student);
    Student updateStudent(Student student);
    void deleteStudent(Long id);
    Student getStudentById(Long id);
    List<Student> getAllStudents();
    List<Student> getStudentsByClasse(Long classeId);
    List<Student> searchStudentsByNom(String nom);
}