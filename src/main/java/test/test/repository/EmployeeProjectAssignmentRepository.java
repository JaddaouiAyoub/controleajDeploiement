package test.test.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test.test.entity.Employee;
import test.test.entity.EmployeeProjectAssignment;

import java.util.List;


@Repository
public interface EmployeeProjectAssignmentRepository extends JpaRepository<EmployeeProjectAssignment, Long> {
    List<EmployeeProjectAssignment> findByEmployee(Employee employee);
}
