package hr.algebra.timesheet.project.repository;

import hr.algebra.timesheet.project.model.Employee;
import hr.algebra.timesheet.project.model.Timesheet;

import java.util.List;
import java.util.Optional;

public interface TimesheetRepository {

    List<Employee> findAll();
    List<Employee> findFilter(Employee criteria);
    Optional<Employee> findById(Long id);
    void addEmployee(Employee employee);
    void deleteEmployee(Employee employee);
}
