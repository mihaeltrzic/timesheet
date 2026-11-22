package hr.algebra.timesheet.project.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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

    @NotBlank(message = "The employee name is required!")
    @Size(max = 50, message = "Please keep the employee name below 50 characters.")
    private String employeeName;

    @Valid()
    @NotNull()
    private Timesheet timesheet;

}
