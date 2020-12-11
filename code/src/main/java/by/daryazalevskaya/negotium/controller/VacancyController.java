package by.daryazalevskaya.negotium.controller;

import by.daryazalevskaya.negotium.entity.employer.Employer;
import by.daryazalevskaya.negotium.entity.employer.Vacancy;
import by.daryazalevskaya.negotium.repos.EmployerRepos;
import by.daryazalevskaya.negotium.repos.UserRepos;
import by.daryazalevskaya.negotium.repos.VacancyRepos;
import by.daryazalevskaya.negotium.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/vacancy")
public class VacancyController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private EmployerRepos employerRepos;

    @Autowired
    private VacancyRepos vacancyRepos;

    @Autowired
    private UserRepos userRepos;

    @GetMapping("/open")
    public String openVacancy(Model model) {
        model.addAttribute("vacancy", new Vacancy());
        return "vacancy";
    }

    @PostMapping("/open")
    public String saveVacancy(@ModelAttribute Vacancy vacancy) {
        Employer currentEmployer=authenticationService.getAuthenticatedEmployer();
        vacancy.setEmployer(currentEmployer);
        vacancyRepos.save(vacancy);
        employerRepos.save(currentEmployer);
        return "redirect:/employer/home";
    }

    @GetMapping("/show")
    public String showVacancies(Model model, Principal principal) {
        model.addAttribute("vacancies", vacancyRepos.findAll());
        model.addAttribute("role", principal);
        return "all-vacancies";
    }

}
