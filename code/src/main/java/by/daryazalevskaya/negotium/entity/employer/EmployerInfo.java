package by.daryazalevskaya.negotium.entity.employer;

import by.daryazalevskaya.negotium.entity.Contact;

import java.util.List;

public class EmployerInfo {
    private String companyName;
    private String taxPayerNumber;
    private String country;
    private String city;
    private Contact contact;
    private List<Vacancy> vacancies;
}
