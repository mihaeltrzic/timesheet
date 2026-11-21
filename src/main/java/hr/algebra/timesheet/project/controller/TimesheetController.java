package hr.algebra.timesheet.project.controller;

import hr.algebra.timesheet.project.model.Employee;
import hr.algebra.timesheet.project.model.TimeEntry;
import hr.algebra.timesheet.project.model.Timesheet;
import hr.algebra.timesheet.project.service.TimesheetService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

}
