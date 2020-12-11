package by.daryazalevskaya.negotium.controller;

import by.daryazalevskaya.negotium.entity.employer.Employer;
import by.daryazalevskaya.negotium.repos.VacancyRepos;
import by.daryazalevskaya.negotium.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employer")
public class EmployerController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private VacancyRepos vacancyRepos;

    @GetMapping("/home")
    public String home(Model model) {
        Employer currentEmployer=authenticationService.getAuthenticatedEmployer();
        model.addAttribute("vacancies", vacancyRepos.findVacanciesByEmployerId(currentEmployer.getId()));
        model.addAttribute("employer", authenticationService.getAuthenticatedEmployer());
        return "employer-home";
    }

}
