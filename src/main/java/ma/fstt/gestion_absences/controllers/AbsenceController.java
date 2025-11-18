package ma.fstt.gestion_absences.controllers;

import ma.fstt.gestion_absences.entities.Absence;
import ma.fstt.gestion_absences.services.IAbsenceService;
import ma.fstt.gestion_absences.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/absences")
public class AbsenceController {

    @Autowired
    private IAbsenceService absenceService;

    @Autowired
    private IStudentService studentService;

    // Afficher la liste des absences
    @GetMapping
    public String listAbsences(Model model) {
        model.addAttribute("absences", absenceService.getAllAbsences());
        return "absences/list";
    }

    // Afficher le formulaire d'ajout
    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("absence", new Absence());
        model.addAttribute("students", studentService.getAllStudents());
        return "absences/form";
    }

    // Afficher le formulaire de modification
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Absence absence = absenceService.getAbsenceById(id);
        model.addAttribute("absence", absence);
        model.addAttribute("students", studentService.getAllStudents());
        return "absences/form";
    }

    // Enregistrer (créer ou modifier)
    @PostMapping("/save")
    public String saveAbsence(@ModelAttribute Absence absence) {
        if (absence.getId() == null) {
            absenceService.saveAbsence(absence);
        } else {
            absenceService.updateAbsence(absence);
        }
        return "redirect:/absences";
    }

    // Supprimer
    @GetMapping("/delete/{id}")
    public String deleteAbsence(@PathVariable Long id) {
        absenceService.deleteAbsence(id);
        return "redirect:/absences";
    }

    // Filtrer par étudiant
    @GetMapping("/student/{studentId}")
    public String listAbsencesByStudent(@PathVariable Long studentId, Model model) {
        model.addAttribute("absences", absenceService.getAbsencesByStudent(studentId));
        model.addAttribute("student", studentService.getStudentById(studentId));
        return "absences/list";
    }
}