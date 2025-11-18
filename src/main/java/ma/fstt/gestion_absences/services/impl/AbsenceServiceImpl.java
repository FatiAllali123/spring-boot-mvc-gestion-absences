package ma.fstt.gestion_absences.services.impl;


import ma.fstt.gestion_absences.entities.Absence;
import ma.fstt.gestion_absences.repositories.AbsenceRepository;
import ma.fstt.gestion_absences.services.IAbsenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;



@Service
public class AbsenceServiceImpl implements IAbsenceService {


    private final AbsenceRepository absenceRepository;
    public AbsenceServiceImpl(AbsenceRepository absenceRepository) {
        this.absenceRepository = absenceRepository;
    }

    @Override
    public Absence saveAbsence(Absence absence) {
        return absenceRepository.save(absence);
    }

    @Override
    public Absence updateAbsence(Absence absence) {
        return absenceRepository.save(absence);
    }

    @Override
    public void deleteAbsence(Long id) {
        absenceRepository.deleteById(id);
    }

    @Override
    public Absence getAbsenceById(Long id) {
        return absenceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Absence non trouvée avec l'id: " + id));
    }

    @Override
    public List<Absence> getAllAbsences() {
        return absenceRepository.findAll();
    }

    @Override
    public List<Absence> getAbsencesByStudent(Long studentId) {
        return absenceRepository.findByStudentId(studentId);
    }

    @Override
    public List<Absence> getAbsencesByDate(LocalDate date) {
        return absenceRepository.findByDate(date);
    }

    @Override
    public List<Absence> getAbsencesBetweenDates(LocalDate startDate, LocalDate endDate) {
        return absenceRepository.findByDateBetween(startDate, endDate);
    }
}