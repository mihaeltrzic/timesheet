package hr.algebra.timesheet.project.service;

import hr.algebra.timesheet.project.model.Employee;
import hr.algebra.timesheet.project.model.EmployeeForm;
import hr.algebra.timesheet.project.model.TimeEntry;
import hr.algebra.timesheet.project.model.Timesheet;
import hr.algebra.timesheet.project.repository.TimesheetRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TimesheetServiceImpl implements TimesheetService{

    private TimesheetRepository timesheetRepository;

    @Override
    public List<EmployeeForm> getEmployees() {
        return timesheetRepository.findAll().stream().map(e -> convertEmployeeToEmployeeForm(e)).toList();
    }

    @Override
    public List<EmployeeForm> filter(EmployeeForm criteria) {
        return timesheetRepository
                .findFilter(convertEmployeeFormToEmployee(criteria))
                .stream().map(e->convertEmployeeToEmployeeForm(e))
                .toList();
    }

    @Override
    public Optional<EmployeeForm> getById(Long id) {
        return timesheetRepository.findById(id).map(e->convertEmployeeToEmployeeForm(e));
    }

    @Override
    public void addEmployee(EmployeeForm employeeForm) {
        timesheetRepository.addEmployee(convertEmployeeFormToEmployee(employeeForm));
    }

    @Override
    public void deleteEmployee(Long id) {
        Optional<Employee> employee = timesheetRepository.findById(id);
        if(employee.isPresent()) {
            timesheetRepository.deleteEmployee(employee.get());
        }
    }

    private Employee convertEmployeeFormToEmployee(EmployeeForm form){
        Employee newEmployee = new Employee();
        newEmployee.setEmployeeID(form.getEmployeeID());
        newEmployee.setEmployeeName(form.getEmployeeName());
        newEmployee.setTimesheet(form.getTimesheet());
        return newEmployee;
    }

    private EmployeeForm convertEmployeeToEmployeeForm(Employee employee){
        EmployeeForm employeeForm = new EmployeeForm();
        employeeForm.setEmployeeID(employee.getEmployeeID());
        employeeForm.setEmployeeName(employee.getEmployeeName());
        employeeForm.setTimesheet(employee.getTimesheet());
        return employeeForm;
    }

}
