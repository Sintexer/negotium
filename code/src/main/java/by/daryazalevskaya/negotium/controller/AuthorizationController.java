package by.daryazalevskaya.negotium.controller;

import by.daryazalevskaya.negotium.entity.Role;
import by.daryazalevskaya.negotium.entity.User;
import by.daryazalevskaya.negotium.entity.employee.Employee;
import by.daryazalevskaya.negotium.entity.employer.Employer;
import by.daryazalevskaya.negotium.repos.EmployeeRepos;
import by.daryazalevskaya.negotium.repos.EmployerRepos;
import by.daryazalevskaya.negotium.repos.UserRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthorizationController {

    @Autowired
    private UserRepos userRepos;


    @GetMapping("/homePage")
    public String homePage() {
        String request;
        User currentUser = userRepos.findUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());

        Role userRole = currentUser.getRole();
        if (userRole == Role.EMPLOYEE) {
            request="redirect:/employee/resume/show";
        } else {
            request = "redirect:/employer/home";
        }
        return request;
    }
}
