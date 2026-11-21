package hr.algebra.timesheet.project.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TimeEntry {

    private LocalDateTime clockIn;
    private LocalDateTime clockOut;

}
