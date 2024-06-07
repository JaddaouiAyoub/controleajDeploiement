package test.test.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test.test.entity.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}