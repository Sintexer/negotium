package by.daryazalevskaya.negotium.entity.employee;

import by.daryazalevskaya.negotium.entity.Contact;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "resume")
@Getter
@Setter
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private EmployeePersonalInfo personalInfo;
    private Contact contact;
    private JobPreference jobPreference;
    private String skills;
    private Language foreignLanguage;
    private LocalDate updateDate;
    private boolean isRaised;

}
