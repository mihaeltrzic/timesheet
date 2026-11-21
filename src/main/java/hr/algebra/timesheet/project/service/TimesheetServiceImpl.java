package hr.algebra.timesheet.project.service;

import hr.algebra.timesheet.project.model.Employee;
import hr.algebra.timesheet.project.repository.TimesheetRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TimesheetServiceImpl implements TimesheetService{

    private TimesheetRepository timesheetRepository;

    @Override
    public List<Employee> getEmployees() {
        return timesheetRepository.findAll();
    }
}
