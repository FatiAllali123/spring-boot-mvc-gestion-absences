package ma.fstt.gestion_absences.services;

import ma.fstt.gestion_absences.entities.Absence;
import java.time.LocalDate;
import java.util.List;

public interface IAbsenceService {
    Absence saveAbsence(Absence absence);
    Absence updateAbsence(Absence absence);
    void deleteAbsence(Long id);
    Absence getAbsenceById(Long id);
    List<Absence> getAllAbsences();
    List<Absence> getAbsencesByStudent(Long studentId);
    List<Absence> getAbsencesByDate(LocalDate date);
    List<Absence> getAbsencesBetweenDates(LocalDate startDate, LocalDate endDate);
}