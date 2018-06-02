package pl.coderslab.taskplanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.taskplanner.model.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}