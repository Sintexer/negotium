package by.daryazalevskaya.negotium.controller;

import by.daryazalevskaya.negotium.entity.Contact;
import by.daryazalevskaya.negotium.entity.employee.*;
import by.daryazalevskaya.negotium.repos.EmployeeRepos;
import by.daryazalevskaya.negotium.repos.UserRepos;
import by.daryazalevskaya.negotium.service.AuthenticationService;
import by.daryazalevskaya.negotium.service.ConvertService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
@RequestMapping("/employee/resume")
public class ResumeController {

    @Autowired
    private EmployeeRepos employeeRepos;

    @Autowired
    private UserRepos userRepos;

    @Autowired
    private AuthenticationService authenticationService;

    private static final String RESUME_PAGE="employee-home";

    @GetMapping("/savePersonalInfo")
    public String editEmployeePersonalInfo(Model model) {
        Employee employee= authenticationService.getAuthentithicatedEmployee();
        model.addAttribute("info", employee.getResume().getPersonalInfo());
        return "personal-employee-info";
    }

    @PostMapping("/savePersonalInfo")
    public String savePersonalInfo(@ModelAttribute EmployeePersonalInfo info, Model model) {
        Employee employee= authenticationService.getAuthentithicatedEmployee();
        employee.getResume().setPersonalInfo(info);
        employeeRepos.save(employee);
        return RESUME_PAGE;
    }

    @GetMapping("/saveContact")
    public String editContact(Model model) {
        Employee employee= authenticationService.getAuthentithicatedEmployee();
        model.addAttribute("contact", employee.getResume().getContact());
        return "contact";
    }

    @PostMapping("/saveContact")
    public String saveContact(@ModelAttribute Contact contact, Model model) {
        Employee employee= authenticationService.getAuthentithicatedEmployee();
        employee.getResume().setContact(contact);
        employeeRepos.save(employee);
        return RESUME_PAGE;
    }

    @GetMapping("/saveJobPreference")
    public String editJobPreference(Model model) {
        Employee employee= authenticationService.getAuthentithicatedEmployee();
        model.addAttribute("jobPreference", employee.getResume().getJobPreference());
        return "job-preference";
    }

    @PostMapping("/saveJobPreference")
    public String saveJobPreference(@ModelAttribute JobPreference jobPreference, Model model) {
        Employee employee= authenticationService.getAuthentithicatedEmployee();
        employee.getResume().setJobPreference(jobPreference);
        employeeRepos.save(employee);
        return RESUME_PAGE;
    }

    @GetMapping("/saveSkills")
    public String editSkills(Model model) {
        Employee employee= authenticationService.getAuthentithicatedEmployee();
        model.addAttribute("skills", employee.getResume().getSkills());
        return "skills";
    }

    @PostMapping("/saveSkills")
    public String saveSkills(@ModelAttribute String skills, Model model) {
        Employee employee= authenticationService.getAuthentithicatedEmployee();
        employee.getResume().setSkills(skills);
        employeeRepos.save(employee);
        return RESUME_PAGE;
    }

    @GetMapping("/saveLanguage")
    public String editLanguage(Model model) {
        Employee employee= authenticationService.getAuthentithicatedEmployee();
        model.addAttribute("language",employee.getResume().getForeignLanguage());
        return "language";
    }

    @PostMapping("/saveLanguage")
    public String saveLanguage(@ModelAttribute Language language, Model model) {
        Employee employee= authenticationService.getAuthentithicatedEmployee();
        employee.getResume().setForeignLanguage(language);
        employeeRepos.save(employee);
        return RESUME_PAGE;
    }


    @GetMapping("/show")
    public String showResume(Model model) {
        Employee employee= authenticationService.getAuthentithicatedEmployee();

        model.addAttribute("resume", employee.getResume());

        Resume resume=employee.getResume();
        if (resume.getPersonalInfo()!=null) {
            LocalDate birthday = employee.getResume().getPersonalInfo().getBirthday();
            ConvertService converter=new ConvertService();
            int age = converter.countAge(birthday);
            model.addAttribute("age", age);
        }


        return RESUME_PAGE;
    }


}
