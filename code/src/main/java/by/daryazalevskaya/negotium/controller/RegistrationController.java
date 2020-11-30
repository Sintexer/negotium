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

import java.util.Set;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private static final Logger logger = LogManager.getLogger(RegistrationController.class);

    @Autowired
    private UserRepos userRepos;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private EmployeeRepos employeeRepos;

    @Autowired
    private EmployerRepos employerRepos;

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
        user.setRoles(Set.of(SecurityRole.USER));
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepos.save(user);
        Role userRole=user.getRole();
        switch (userRole) {
            case EMPLOYEE:
                employeeRepos.save(new Employee(user));
                break;
            case EMPLOYER:
               employerRepos.save(new Employer(user));
                break;
        }


        return "redirect:/login";
    }

}
