package test.test.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import test.test.entity.Employee;
import test.test.entity.EmployeeProjectAssignment;
import test.test.entity.Project;
import test.test.service.EmployeeProjectAssignmentService;
import test.test.service.EmployeeService;
import test.test.service.ProjectService;


import java.util.List;

@RestController
public class EmployeeProjectAssignmentController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private EmployeeProjectAssignmentService employeeProjectService;

    @GetMapping("/assign")
    public String showAssignPage(Model model) {
        List<Employee> employees = employeeService.getAllEmployees();
        List<Project> projects = projectService.getAllProjects();

        model.addAttribute("employees", employees);
        model.addAttribute("projects", projects);
        model.addAttribute("employeeProject", new EmployeeProjectAssignment());

        return "assign";
    }

    @PostMapping("/assign")
    public String assignEmployeeToProject(@ModelAttribute EmployeeProjectAssignment employeeProject) {
        employeeProjectService.saveEmployeeProject(employeeProject);
        return "redirect:/assign";
    }
}

