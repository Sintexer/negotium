package by.daryazalevskaya.negotium.entity.employee;

import by.daryazalevskaya.negotium.entity.Contact;

import java.time.LocalDate;
import java.util.List;

public class Resume {
    private EmployeePersonalInfo personalInfo;
    private Contact contact;
    private JobPreference jobPreference;
    private List<String> skills;
    private List<Language> languages;
    private LocalDate updateDate;
    private boolean isRaised;
}
