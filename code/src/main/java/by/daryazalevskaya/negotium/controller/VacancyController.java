package by.daryazalevskaya.negotium.controller;

import by.daryazalevskaya.negotium.entity.employer.Employer;
import by.daryazalevskaya.negotium.entity.employer.Vacancy;
import by.daryazalevskaya.negotium.repos.EmployerRepos;
import by.daryazalevskaya.negotium.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller("/employer/vacancy")
public class VacancyController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private EmployerRepos employerRepos;

    @GetMapping("/open")
    public String openVacancy(Model model) {
        //TODO create page of creation vacancy
        model.addAttribute("vacancy", new Vacancy());
        return "vacancy";
    }

    @PostMapping("/open")
    public String saveVacancy(@ModelAttribute Vacancy vacancy) {
        Employer currentEmployer=authenticationService.getAuthentithicatedEmployer();
        currentEmployer.addVacancy(vacancy);
        employerRepos.save(currentEmployer);
        return "redirect:/employer/home";
    }

}
