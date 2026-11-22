package hr.algebra.timesheet.project.repository;

import hr.algebra.timesheet.project.model.Employee;
import hr.algebra.timesheet.project.model.TimeEntry;
import hr.algebra.timesheet.project.model.Timesheet;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class MockTimesheetRepository implements TimesheetRepository{

    private final List<Employee> employees;

    public MockTimesheetRepository(){
        employees = new ArrayList<>();

        Employee employee1 = new Employee(1L,"Mihael Trzic",new Timesheet(new TimeEntry(
                LocalDateTime.of(2026,11,21,8,0),
                LocalDateTime.of(2026,11,21,16,0))));

        employees.add(employee1);
    }

    @Override
    public List<Employee> findAll() {
    return employees;
    }

    @Override
    public List<Employee> findFilter(Employee criteria) {
        return employees.stream()
                .filter(e->e.getEmployeeName().contains(criteria.getEmployeeName()))
                .toList();
    }

    @Override
    public Optional<Employee> findById(Long id) {
        for(Employee employee : employees){
            if(employee.getEmployeeID() == id){
                return Optional.of(employee);
            }
        }
        return Optional.empty();
    }

    @Override
    public void addEmployee(Employee employee) {
        if(Optional.ofNullable(employee.getEmployeeID()).isPresent()){
            Employee employeeUpdate = findById(employee.getEmployeeID()).get();
            employeeUpdate.setEmployeeName(employee.getEmployeeName());
            employeeUpdate.setTimesheet(new Timesheet(new TimeEntry(employee.getTimesheet().getTimesheetClockInOut().getClockIn(), employee.getTimesheet().getTimesheetClockInOut().getClockOut())));
        }
        else {
            employee.setEmployeeID(generateNextId());
            employees.add(employee);
        }
    }

    @Override
    public void deleteEmployee(Employee employee) {
        employees.remove(employee);
    }

    private Long generateNextId(){
        return employees.stream().map(Employee::getEmployeeID).max(Long::compareTo).orElse(0L)+1L;
    }

}
