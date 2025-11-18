package ma.fstt.gestion_absences.services.impl;

import ma.fstt.gestion_absences.entities.Student;
import ma.fstt.gestion_absences.repositories.ClassEcoleRepository;
import ma.fstt.gestion_absences.repositories.StudentRepository;
import ma.fstt.gestion_absences.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {


    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Étudiant non trouvé avec l'id: " + id));
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> getStudentsByClasse(Long classeId) {
        return studentRepository.findByClasseId(classeId);
    }

    @Override
    public List<Student> searchStudentsByNom(String nom) {
        return studentRepository.findByNomContainingIgnoreCase(nom);
    }
}