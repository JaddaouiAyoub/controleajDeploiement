package test.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.test.entity.EmployeeProjectAssignment;
import test.test.repository.EmployeeProjectAssignmentRepository;


import java.util.List;
import java.util.Optional;

@Service
public class EmployeeProjectAssignmentService {

    @Autowired
    private EmployeeProjectAssignmentRepository employeeProjectRepository;

    public List<EmployeeProjectAssignment> getAllEmployeeProjects() {
        return employeeProjectRepository.findAll();
    }

    public Optional<EmployeeProjectAssignment> getEmployeeProjectById(Long id) {
        return employeeProjectRepository.findById(id);
    }

    public EmployeeProjectAssignment saveEmployeeProject(EmployeeProjectAssignment employeeProject) {
        return employeeProjectRepository.save(employeeProject);
    }

    public void deleteEmployeeProject(Long id) {
        employeeProjectRepository.deleteById(id);
    }
}

