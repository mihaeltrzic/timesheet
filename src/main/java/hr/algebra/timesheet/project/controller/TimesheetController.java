package hr.algebra.timesheet.project.controller;

import hr.algebra.timesheet.project.model.Employee;
import hr.algebra.timesheet.project.model.EmployeeForm;
import hr.algebra.timesheet.project.model.TimeEntry;
import hr.algebra.timesheet.project.model.Timesheet;
import hr.algebra.timesheet.project.service.TimesheetService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("timesheet")
@AllArgsConstructor
public class TimesheetController {

    private TimesheetService timesheetService;

    @GetMapping("/list")
    public String TimesheetIndex(Model model){

        model.addAttribute("employees",timesheetService.getEmployees());

        //name matches the .html file
        return "timesheet_index";
    }

    @GetMapping("/new")
    public String TimesheetNewGet(Model model){
        model.addAttribute("employeeForm",new EmployeeForm());
        return "timesheet_new";
    }

    @PostMapping("/new")
    public String TimesheetNew(@Valid @ModelAttribute("employeeForm") EmployeeForm form,
                               BindingResult result, RedirectAttributes redirect){

        if(result.hasErrors()){
            return "timesheet_new";
        }
        if(Optional.ofNullable(form.getEmployeeID()).isPresent()){
            redirect.addFlashAttribute("toast", "Updated " + form.getEmployeeName() + ".");
        }else {
            redirect.addFlashAttribute("toast", "Added " + form.getEmployeeName() + " to the list.");
        }
        timesheetService.addEmployee(form);
        return "redirect:/timesheet/list";
    }

    @PostMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") Long id,
                                 RedirectAttributes redirect){
        Optional<EmployeeForm> employeeID = timesheetService.getById(id);

        if(Optional.ofNullable(employeeID).isPresent()){
            timesheetService.deleteEmployee(id);
            redirect.addFlashAttribute("toast", "Deleted " + employeeID.get().getEmployeeName() + " from the list.");
        }else{
            redirect.addFlashAttribute("toast", "Timesheet with id " + employeeID.get().getEmployeeID() + " not found.");
        }

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

    @GetMapping("/filter")
    public String filter(@RequestParam(required = false, defaultValue = "") String query, Model model){

        EmployeeForm form = new EmployeeForm();
        form.setEmployeeName(query);
        List<EmployeeForm> employeeFormList = timesheetService.filter(form);

        model.addAttribute("employees",employeeFormList);

        return "/timesheet_index";
    }

}
