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
        timesheetService.addEmployee(form);
        return "redirect:/timesheet/list";
    }

    @PostMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") Long id){
        timesheetService.deleteEmployee(id);
        //TODO check if it exists
        return "redirect:/timesheet/list";
    }

    @GetMapping("/edit/{id}")
    public String editEmployee(Model model, @PathVariable Long id){
        Optional<EmployeeForm> employeeForm = timesheetService.getById(id);
        if(employeeForm.isPresent()){
            EmployeeForm employee = employeeForm.get();
            model.addAttribute("employeeForm", employee);
            return "timesheet_new";
        }
        else{
            //TODO display error message
            return "redirect:/timesheet/list";
        }
    }

}
