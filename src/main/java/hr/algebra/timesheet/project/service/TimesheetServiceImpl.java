package hr.algebra.timesheet.project.service;

import hr.algebra.timesheet.project.model.Employee;
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
    public List<Employee> getEmployees() {
        return timesheetRepository.findAll();
    }

    @Override
    public Optional<Employee> getById(Long id) {
        return timesheetRepository.findById(id);
    }

    @Override
    public void addEmployee(Employee employee) {
        timesheetRepository.addEmployee(employee);
    }

    @Override
    public void deleteEmployee(Employee employee) {
        timesheetRepository.deleteEmployee(employee);
    }
}
