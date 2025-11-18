package ma.fstt.gestion_absences.services;

import ma.fstt.gestion_absences.entities.ClasseEcole;
import java.util.List;

public interface IClasseEcoleService {
    ClasseEcole saveClasse(ClasseEcole classe);
    ClasseEcole updateClasse(ClasseEcole classe);
    void deleteClasse(Long id);
    ClasseEcole getClasseById(Long id);
    List<ClasseEcole> getAllClasses();
}