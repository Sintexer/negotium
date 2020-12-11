package by.daryazalevskaya.negotium.service;

import by.daryazalevskaya.negotium.entity.Role;
import by.daryazalevskaya.negotium.entity.SecurityRole;
import by.daryazalevskaya.negotium.entity.User;
import by.daryazalevskaya.negotium.entity.employee.Employee;
import by.daryazalevskaya.negotium.entity.employer.Employer;
import by.daryazalevskaya.negotium.repos.EmployeeRepos;
import by.daryazalevskaya.negotium.repos.EmployerRepos;
import by.daryazalevskaya.negotium.repos.UserRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepos userRepos;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private EmployeeRepos employeeRepos;

    @Autowired
    private EmployerRepos employerRepos;

    public void addUser(User user) {
        user.setActive(true);
        user.setRoles(Set.of(SecurityRole.USER));
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepos.save(user);
    }

    public void addUserAsRole(User user) {
        Role userRole=user.getRole();
        switch (userRole) {
            case EMPLOYEE:
                employeeRepos.save(new Employee(user));
                break;
            case EMPLOYER:
                employerRepos.save(new Employer(user));
                break;
        }

    }
}
