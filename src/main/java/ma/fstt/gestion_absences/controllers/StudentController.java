package ma.fstt.gestion_absences.controllers;

import ma.fstt.gestion_absences.entities.Student;
import ma.fstt.gestion_absences.services.IStudentService;
import ma.fstt.gestion_absences.services.IClasseEcoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @Autowired
    private IClasseEcoleService classeService;

    // Afficher la liste des étudiants
    @GetMapping
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "students/list";
    }

    // Afficher le formulaire d'ajout
    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("classes", classeService.getAllClasses());
        return "students/form";
    }

    // Afficher le formulaire de modification
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        model.addAttribute("classes", classeService.getAllClasses());
        return "students/form";
    }

    // Enregistrer (créer ou modifier)
    @PostMapping("/save")
    public String saveStudent(@ModelAttribute Student student) {
        if (student.getId() == null) {
            studentService.saveStudent(student);
        } else {
            studentService.updateStudent(student);
        }
        return "redirect:/students";
    }

    // Supprimer
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }

    // Rechercher par nom
    @GetMapping("/search")
    public String searchStudents(@RequestParam String nom, Model model) {
        model.addAttribute("students", studentService.searchStudentsByNom(nom));
        return "students/list";
    }
}
