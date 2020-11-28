package by.daryazalevskaya.negotium.controller;

import by.daryazalevskaya.negotium.entity.Role;
import by.daryazalevskaya.negotium.repos.UserRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthorizationController {

    @Autowired
    private UserRepos userRepos;

    @GetMapping("/homePage")
    public String homePage(Authentication authentication) {
        String homePage;
        Role userRole = userRepos.findUserByUsername(authentication.getName()).getRole();
        if (userRole == Role.EMPLOYEE) {
            homePage = "homeEmployee";
        } else {
            homePage = "homeEmployer";
        }
        return homePage;
    }
}
