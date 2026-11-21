package hr.algebra.timesheet.project.repository;

import hr.algebra.timesheet.project.model.Employee;
import hr.algebra.timesheet.project.model.Timesheet;

import java.util.List;
import java.util.Optional;

public interface TimesheetRepository {

    List<Employee> findAll();
    Optional<Employee> findById(Long id);
    void addEmployee(Employee employee);
    void deleteEmployee(Employee employee);
}
