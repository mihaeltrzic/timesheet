package hr.algebra.timesheet.project.repository;

import hr.algebra.timesheet.project.model.Employee;
import hr.algebra.timesheet.project.model.Timesheet;

import java.util.List;

public interface TimesheetRepository {

    List<Employee> findAll();

}
