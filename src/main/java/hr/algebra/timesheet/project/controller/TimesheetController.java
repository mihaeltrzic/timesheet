package hr.algebra.timesheet.project.controller;

import hr.algebra.timesheet.project.model.Employee;
import hr.algebra.timesheet.project.model.EmployeeForm;
import hr.algebra.timesheet.project.model.TimeEntry;
import hr.algebra.timesheet.project.model.Timesheet;
import hr.algebra.timesheet.project.service.TimesheetService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("timesheet")
@AllArgsConstructor
public class TimesheetController {

    private TimesheetService timesheetService;

    @GetMapping("/list")
    public String TimesheetIndex(Model model){

        model.addAttribute("employees",timesheetService.getEmployees());

        //name matches the html file
        return "timesheet_index";
    }

    @GetMapping("/new")
    public String TimesheetNewGet(Model model){
        model.addAttribute("employeeForm",new EmployeeForm());
        return "timesheet_new";
    }

    @PostMapping("/new")
    public String TimesheetNew(@ModelAttribute("employeeForm") EmployeeForm form){
        Employee newEmployee = convertFormToObject(form);
        timesheetService.addEmployee(newEmployee);
        return "redirect:/timesheet/list";
    }

    private Employee convertFormToObject(EmployeeForm form){
        Employee newEmployee = new Employee();
        newEmployee.setEmployeeName(form.getName());
        newEmployee.setTimesheet(new Timesheet(new TimeEntry(form.getTimesheet().getTimesheetClockInOut().getClockIn(), form.getTimesheet().getTimesheetClockInOut().getClockOut())));
        return newEmployee;
    }

    @PostMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") Long id){
        Optional<Employee> deleteEmployee = timesheetService.getById(id);
        if(deleteEmployee.isPresent()){
            timesheetService.deleteEmployee(deleteEmployee.get());
        }
        return "redirect:/timesheet/list";
    }

}
