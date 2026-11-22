package hr.algebra.timesheet.project.service;

import hr.algebra.timesheet.project.model.EmployeeForm;

import java.util.List;
import java.util.Optional;

public interface TimesheetService {

    List<EmployeeForm> getEmployees();
    Optional<EmployeeForm> getById(Long id);
    void addEmployee(EmployeeForm employee);
    void deleteEmployee(Long id);
}
