package hr.algebra.timesheet.project.service;

import hr.algebra.timesheet.project.model.Employee;

import java.util.List;
import java.util.Optional;

public interface TimesheetService {

    List<Employee> getEmployees();
    Optional<Employee> getById(Long id);
    void addEmployee(Employee employee);
    void deleteEmployee(Employee employee);
}
