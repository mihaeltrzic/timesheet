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
    private Long employeeID;
    private String employeeName;
    private Timesheet timesheet;

}
