package by.daryazalevskaya.negotium.controller;

import by.daryazalevskaya.negotium.entity.Contact;
import by.daryazalevskaya.negotium.entity.employee.Employee;
import by.daryazalevskaya.negotium.entity.employee.EmployeePersonalInfo;
import by.daryazalevskaya.negotium.entity.employee.JobPreference;
import by.daryazalevskaya.negotium.entity.employee.Language;
import by.daryazalevskaya.negotium.service.ConvertService;
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

    @GetMapping("/savePersonalInfo")
    public String editEmployeePersonalInfo(Model model) {
        //TODO получить резюме текущего пользователя
        model.addAttribute("info", new EmployeePersonalInfo());
        return "personal-employee-info";
    }

    @PostMapping("/savePersonalInfo")
    public String savePersonalInfo(@ModelAttribute EmployeePersonalInfo info, Model model) {
        //получить текущего юзера и сохранить в него info
        return "showResume";
    }

    @GetMapping("/saveContact")
    public String editContact(Model model) {
        //TODO получить резюме текущего пользователя
        model.addAttribute("contact", new Contact());
        return "contact";
    }

    @PostMapping("/saveContact")
    public String saveContact(@ModelAttribute Contact contact, Model model) {
        //получить текущего юзера и сохранить в него contact
        return "showResume";
    }

    @GetMapping("/saveJobPreference")
    public String editJobPreference(Model model) {
        //TODO получить резюме текущего пользователя
        model.addAttribute("jobPreference", new JobPreference());
        return "job-preference";
    }

    @PostMapping("/saveJobPreference")
    public String saveJobPreference(@ModelAttribute JobPreference jobPreference, Model model) {
        //получить текущего юзера и сохранить в него contact
        return "showResume";
    }

    @GetMapping("/saveSkills")
    public String editSkills(Model model) {
        //TODO получить резюме текущего пользователя
        model.addAttribute("skills", "");
        return "skills";
    }

    @PostMapping("/saveSkills")
    public String saveSkills(@ModelAttribute String skills, Model model) {
        //получить текущего юзера и сохранить в него contact
        return "showResume";
    }

    @GetMapping("/saveLanguage")
    public String editLanguage(Model model) {
        //TODO получить резюме текущего пользователя
        model.addAttribute("language", new Language());
        return "language";
    }

    @PostMapping("/saveLanguage")
    public String saveLanguage(@ModelAttribute Language language, Model model) {
        //получить текущего юзера и сохранить в него contact
        return "showResume";
    }

    @GetMapping("/show")
    public String showResume(Model model) {
        Employee employee = new Employee();

        //получить текущего юезра,достать от него резюме
        model.addAttribute("resume", employee.getResume());
        LocalDate birthday = employee.getResume().getPersonalInfo().getBirthday();
        ConvertService converter=new ConvertService();
        int age = converter.countAge(birthday);
        model.addAttribute("age", age);
        return "showResume";
    }


}
