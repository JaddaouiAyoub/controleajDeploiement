package test.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import test.test.entity.Employee;
import test.test.entity.EmployeeProjectAssignment;
import test.test.entity.Project;
import test.test.repository.EmployeeProjectAssignmentRepository;
import test.test.repository.EmployeeRepository;
import test.test.service.EmployeeProjectAssignmentService;
import test.test.service.EmployeeService;
import test.test.service.ProjectService;


import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
public class ThymleafController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private EmployeeProjectAssignmentService employeeProjectService;
    @Autowired
    private EmployeeProjectAssignmentRepository employeeProjectAssignmentRepository;
    @Autowired
    private EmployeeProjectAssignmentService employeeProjectAssignment;

    @GetMapping("/login")
    public String login() {
        return "login";
    }
    @GetMapping("/assignT")
    public String showAssignPage(Model model) {
        List<Employee> employees = employeeService.getAllEmployees();
        List<Project> projects = projectService.getAllProjects();

        model.addAttribute("employees", employees);
        model.addAttribute("projects", projects);
        model.addAttribute("employeeProjectAssignment", new EmployeeProjectAssignment());

        return "assign";
    }

    @PostMapping("/assignT")
    public String assignEmployeeToProject(@ModelAttribute EmployeeProjectAssignment employeeProject) {
        employeeProjectService.saveEmployeeProject(employeeProject);
        return "redirect:/employees";
    }

    @GetMapping("/employees")
    public String showEmployeeList(Model model) {
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);
        return "employee-list";
    }
    @GetMapping("/employees/delete/{id}")
    public String deleteEmployee(@PathVariable("id") Long id, Model model) {
        // Vérifier si l'employé existe
        if (employeeService.getEmployeeById(id) == null) {
            // Si l'employé n'existe pas, afficher un message d'erreur
            model.addAttribute("errorMessage", "L'employé n'existe pas.");
            return "error";
        }

        // Supprimer l'employé
        employeeService.deleteEmployee(id);
        return "redirect:/employees";
    }

    @GetMapping("/employees/add")
    public String showAddEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
//        model.addAttribute("skills", ""); // Initialiser la variable de modèle "skills"
        return "add-employee";
    }

    @PostMapping("/employees/add")
    public String addEmployee(@ModelAttribute Employee employee) {

        // Convertir la chaîne de compétences saisie par l'utilisateur en un ensemble de compétences
        String skillsInput = String.valueOf(employee.getSkills());
        List<String> skills = Arrays.stream(skillsInput.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
        employee.setSkills(skills);

        employeeRepository.save(employee);
        return "redirect:/employees";
    }

}
