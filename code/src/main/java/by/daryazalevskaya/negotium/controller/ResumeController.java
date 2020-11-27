package by.daryazalevskaya.negotium.controller;

import by.daryazalevskaya.negotium.entity.employee.Employee;
import by.daryazalevskaya.negotium.entity.employee.EmployeePersonalInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.time.Period;

@Controller
@RequestMapping("/resume")
public class ResumeController {

    @GetMapping("/{resumePart}")
    public String editResumeForm(@PathVariable String resumePart) {
        //HTML pages call as path variable
        //TODO create html pages
        return resumePart;
    }


    @GetMapping("/savePersonalInfo")
    public String getPersonalInfo(Model model) {
        //TODO получить резюме текущего пользователя
        model.addAttribute("info", new EmployeePersonalInfo());
        return "personal-employee-info";
    }

    @PostMapping("/savePersonalInfo")
    public String editEmployeePersonalInfo(@ModelAttribute EmployeePersonalInfo info, Model model) {
        //получить текущего юзера и сохранить в него info
        return "showResume";
    }

    @GetMapping("/show")
    public String showResume(Model model) {
        Employee employee = new Employee();
        //получить текущего юезра,достать от него резюме
        model.addAttribute("resume", employee.getResume());
        LocalDate birthday = employee.getResume().getPersonalInfo().getBirthday();
        int age = Period.between(birthday, LocalDate.now()).getYears();
        model.addAttribute("age", age);
        return "showResume";
    }


}
