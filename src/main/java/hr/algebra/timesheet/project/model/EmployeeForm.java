package hr.algebra.timesheet.project.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmployeeForm {
    //DTO aka records are read only
    private String name;
    private Timesheet timesheet;

}
