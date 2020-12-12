package by.daryazalevskaya.negotium.controller;

import by.daryazalevskaya.negotium.entity.Contact;
import by.daryazalevskaya.negotium.entity.employee.Employee;
import by.daryazalevskaya.negotium.entity.employee.EmployeePersonalInfo;
import by.daryazalevskaya.negotium.entity.employee.JobPreference;
import by.daryazalevskaya.negotium.entity.employee.Language;
import by.daryazalevskaya.negotium.entity.employee.Resume;
import by.daryazalevskaya.negotium.repos.EmployeeRepos;
import by.daryazalevskaya.negotium.service.AuthenticationService;
import by.daryazalevskaya.negotium.service.ConvertService;
import by.daryazalevskaya.negotium.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
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
    private EmployeeService employeeService;

    @Autowired
    private AuthenticationService authenticationService;

    private static final String REDIRECT_REQUEST ="redirect:/employee/resume/show";

    @GetMapping("/savePersonalInfo")
    public String editEmployeePersonalInfo(Model model) {
        Employee employee= authenticationService.getAuthenticatedEmployee();
        model.addAttribute("info", employeeService.getPersonalInfo(employee.getResume()));
        return "personal-employee-info";
    }

    @PostMapping("/savePersonalInfo")
    public String savePersonalInfo(@ModelAttribute EmployeePersonalInfo info) {
        Employee employee= authenticationService.getAuthenticatedEmployee();
        employee.getResume().setPersonalInfo(info);
        employeeRepos.save(employee);
        return REDIRECT_REQUEST;
    }

    @GetMapping("/saveContact")
    public String editContact(Model model) {
        Employee employee= authenticationService.getAuthenticatedEmployee();
        model.addAttribute("contact", employeeService.getContact(employee.getResume()));
        return "contact";
    }

    @PostMapping("/saveContact")
    public String saveContact(@ModelAttribute Contact contact, Model model) {
        Employee employee= authenticationService.getAuthenticatedEmployee();
        employee.getResume().setContact(contact);
        employeeRepos.save(employee);
        return REDIRECT_REQUEST;
    }

    @GetMapping("/saveJobPreference")
    public String editJobPreference(Model model) {
        Employee employee= authenticationService.getAuthenticatedEmployee();
        model.addAttribute("jobPreference", employeeService.getJobPreference(employee.getResume()));
        return "job-preference";
    }

    @PostMapping("/saveJobPreference")
    public String saveJobPreference(@ModelAttribute JobPreference jobPreference, Model model) {
        Employee employee= authenticationService.getAuthenticatedEmployee();
        employee.getResume().setJobPreference(jobPreference);
        employeeRepos.save(employee);
        return REDIRECT_REQUEST;
    }

    @GetMapping("/saveSkills")
    public String editSkills(Model model) {
        Employee employee= authenticationService.getAuthenticatedEmployee();
        model.addAttribute("skills", employee.getResume().getSkills());
        return "skills";
    }

    @PostMapping("/saveSkills")
    public String saveSkills(@ModelAttribute String skills, Model model) {
        Employee employee= authenticationService.getAuthenticatedEmployee();
        employee.getResume().setSkills(skills);
        employeeRepos.save(employee);
        return REDIRECT_REQUEST;
    }

    @GetMapping("/saveLanguage")
    public String editLanguage(Model model) {
        Employee employee= authenticationService.getAuthenticatedEmployee();
        model.addAttribute("language",employeeService.getLanguage(employee.getResume()));
        return "language";
    }

    @PostMapping("/saveLanguage")
    public String saveLanguage(@ModelAttribute Language language, Model model) {
        Employee employee= authenticationService.getAuthenticatedEmployee();
        employee.getResume().setForeignLanguage(language);
        employeeRepos.save(employee);
        return REDIRECT_REQUEST;
    }


    @GetMapping("/show")
    public String showResume(Model model) {
        Employee employee= authenticationService.getAuthenticatedEmployee();

        model.addAttribute("resume", employee.getResume());

        Resume resume=employee.getResume();
        if (resume.getPersonalInfo()!=null) {
            LocalDate birthday = employee.getResume().getPersonalInfo().getBirthday();
            ConvertService converter=new ConvertService();
            int age = converter.countAge(birthday);
            model.addAttribute("age", age);
        }


        return "employee-home";
    }


}
