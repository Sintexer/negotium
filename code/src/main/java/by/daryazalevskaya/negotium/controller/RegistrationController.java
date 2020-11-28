package by.daryazalevskaya.negotium.controller;

import by.daryazalevskaya.negotium.entity.Role;
import by.daryazalevskaya.negotium.entity.SecurityRole;
import by.daryazalevskaya.negotium.entity.User;
import by.daryazalevskaya.negotium.entity.employee.Employee;
import by.daryazalevskaya.negotium.entity.employer.Employer;
import by.daryazalevskaya.negotium.repos.EmployeeRepos;
import by.daryazalevskaya.negotium.repos.EmployerRepos;
import by.daryazalevskaya.negotium.repos.UserRepos;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private static final Logger logger = LogManager.getLogger(RegistrationController.class);

    @Autowired
    private UserRepos userRepos;

    @Autowired
    private EmployerRepos employerRepos;

    @Autowired
    private EmployeeRepos employeeRepos;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping
    public String registration(Model model) {

        model.addAttribute("roles", Role.values());
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping
    public String addUser(User user, Model model) {
        User userFromDb = userRepos.findUserByUsername(user.getUsername());

        if (userFromDb != null) {
            model.addAttribute("message_exists", "User exists!");
            return "registration";
        }

        user.setActive(true);
        Set<SecurityRole> roles=new HashSet<>();
        roles.add(SecurityRole.USER);
        user.setRoles(roles);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        Role userRole=user.getRole();
        switch (userRole) {
            case EMPLOYEE:
                Employee employee=new Employee();
                employee.setUser(user);
                employeeRepos.save(employee);
                break;
            case EMPLOYER:
                Employer employer=new Employer();
                employer.setUser(user);
                employerRepos.save(employer);
                break;
        }

        User userr1=userRepos.save(user);
        logger.info(userr1);
        return "redirect:/login";
    }

}
