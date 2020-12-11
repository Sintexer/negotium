package by.daryazalevskaya.negotium.service;

import by.daryazalevskaya.negotium.entity.employee.EmployeePersonalInfo;
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

}
