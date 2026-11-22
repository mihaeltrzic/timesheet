package hr.algebra.timesheet.project.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Timesheet {
    @Valid()
    @NotNull()
    private TimeEntry timesheetClockInOut;
}
