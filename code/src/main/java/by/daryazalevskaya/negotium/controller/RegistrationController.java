package by.daryazalevskaya.negotium.controller;

import by.daryazalevskaya.negotium.entity.Role;
import by.daryazalevskaya.negotium.entity.User;
import by.daryazalevskaya.negotium.entity.employee.Employee;
import by.daryazalevskaya.negotium.entity.employer.Employer;
import by.daryazalevskaya.negotium.repos.EmployeeRepos;
import by.daryazalevskaya.negotium.repos.EmployerRepos;
import by.daryazalevskaya.negotium.repos.UserRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private UserRepos userRepos;

    @Autowired
    private EmployerRepos employerRepos;

    @Autowired
    private EmployeeRepos employeeRepos;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping
    public String registration() {
        return "registration";
    }

    @PostMapping
    public String addUser(User user, Model model) {
        User userFromDb = userRepos.findUserByEmail(user.getEmail());
        if (userFromDb != null) {
            model.addAttribute("message_exists", "User exists!");
            return "registration";
        }

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

        userRepos.save(user);
        return "redirect:/login";
    }

}
