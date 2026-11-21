package hr.algebra.timesheet.project.repository;

import hr.algebra.timesheet.project.model.Employee;
import hr.algebra.timesheet.project.model.TimeEntry;
import hr.algebra.timesheet.project.model.Timesheet;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MockTimesheetRepository implements TimesheetRepository{
    @Override
    public List<Employee> findAll() {
        Employee employee1 = new Employee("Mihael Trzic",new Timesheet(new TimeEntry(
                LocalDateTime.of(2026,11,21,8,0),
                LocalDateTime.of(2026,11,21,16,0))));
        List<Employee> employees = new ArrayList<>();

        employees.add(employee1);
    return employees;
    }

}
