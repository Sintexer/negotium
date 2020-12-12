package by.daryazalevskaya.negotium.service;

import by.daryazalevskaya.negotium.entity.Contact;
import by.daryazalevskaya.negotium.entity.employee.EmployeePersonalInfo;
import by.daryazalevskaya.negotium.entity.employee.JobPreference;
import by.daryazalevskaya.negotium.entity.employee.Language;
import by.daryazalevskaya.negotium.entity.employee.Resume;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    public EmployeePersonalInfo getPersonalInfo(Resume resume) {
        if (resume.getPersonalInfo() == null) {
            resume.setPersonalInfo(new EmployeePersonalInfo());
        }
        return resume.getPersonalInfo();
    }

    public Contact getContact(Resume resume) {
        if (resume.getContact() == null) {
            resume.setContact(new Contact());
        }
        return resume.getContact();
    }

    public JobPreference getJobPreference(Resume resume) {
        if (resume.getJobPreference() == null) {
            resume.setJobPreference(new JobPreference());
        }
        return resume.getJobPreference();
    }


    public Language getLanguage(Resume resume) {
        if (resume.getForeignLanguage() == null) {
            resume.setForeignLanguage(new Language());
        }
        return resume.getForeignLanguage();
    }
}
