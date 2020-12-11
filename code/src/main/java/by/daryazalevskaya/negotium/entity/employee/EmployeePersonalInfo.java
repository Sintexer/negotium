package by.daryazalevskaya.negotium.entity.employee;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Embeddable;
import java.time.LocalDate;

@Embeddable
@Data
public class EmployeePersonalInfo {
    private String name;
    private String surname;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;
    private String gender;
    private String country;
    private String city;
}
