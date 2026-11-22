package hr.algebra.timesheet.project.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TimeEntry {

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @Valid()
    @NotNull(message = "Please enter a valid clock in date and time.")
    private LocalDateTime clockIn;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @Valid()
    @NotNull(message = "Please enter a valid clock out date and time.")
    private LocalDateTime clockOut;

}
