package ma.fstt.gestion_absences.services.impl;

import ma.fstt.gestion_absences.entities.ClasseEcole;
import ma.fstt.gestion_absences.repositories.ClassEcoleRepository;
import ma.fstt.gestion_absences.services.IClasseEcoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClasseEcoleServiceImpl implements IClasseEcoleService {

    private final ClassEcoleRepository classeRepository;

     public ClasseEcoleServiceImpl(ClassEcoleRepository classeRepository) {
             this.classeRepository = classeRepository;
     }

    @Override
    public ClasseEcole saveClasse(ClasseEcole classe) {
        return classeRepository.save(classe);
    }

    @Override
    public ClasseEcole updateClasse(ClasseEcole classe) {
        return classeRepository.save(classe);
    }

    @Override
    public void deleteClasse(Long id) {
        classeRepository.deleteById(id);
    }

    @Override
    public ClasseEcole getClasseById(Long id) {
        return classeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Classe non trouvée avec l'id: " + id));
    }

    @Override
    public List<ClasseEcole> getAllClasses() {
        return classeRepository.findAll();
    }
}
