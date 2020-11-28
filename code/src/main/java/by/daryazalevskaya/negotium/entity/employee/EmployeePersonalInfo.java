package by.daryazalevskaya.negotium.entity.employee;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.time.LocalDate;

@Embeddable
@Data
public class EmployeePersonalInfo {
    private String name;
    private String surname;
    private LocalDate birthday;
    private String gender;
    private String country;
    private String city;
}
