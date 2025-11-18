package ma.fstt.gestion_absences.controllers;


import ma.fstt.gestion_absences.entities.ClasseEcole;
import ma.fstt.gestion_absences.services.IClasseEcoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/classes")
public class ClasseEcoleController {

    @Autowired
    private IClasseEcoleService classeService;

    // Afficher la liste des classes
    @GetMapping
    public String listClasses(Model model) {
        model.addAttribute("classes", classeService.getAllClasses());
        return "classes/list";
    }

    // Afficher le formulaire d'ajout
    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("classe", new ClasseEcole());
        return "classes/form";
    }

    // Afficher le formulaire de modification
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        ClasseEcole classe = classeService.getClasseById(id);
        model.addAttribute("classe", classe);
        return "classes/form";
    }

    // Enregistrer (créer ou modifier)
    @PostMapping("/save")
    public String saveClasse(@ModelAttribute ClasseEcole classe) {
        if (classe.getId() == null) {
            classeService.saveClasse(classe);
        } else {
            classeService.updateClasse(classe);
        }
        return "redirect:/classes";
    }

    // Supprimer
    @GetMapping("/delete/{id}")
    public String deleteClasse(@PathVariable Long id) {
        classeService.deleteClasse(id);
        return "redirect:/classes";
    }
}