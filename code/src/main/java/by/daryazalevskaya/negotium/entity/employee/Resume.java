package by.daryazalevskaya.negotium.entity.employee;

import by.daryazalevskaya.negotium.entity.Contact;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "resume")
@Data
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private EmployeePersonalInfo personalInfo;
    private Contact contact;

    private JobPreference jobPreference=new JobPreference();
    private String skills;
    private Language foreignLanguage;
    private LocalDate updateDate;
    private boolean isRaised=false;

}
