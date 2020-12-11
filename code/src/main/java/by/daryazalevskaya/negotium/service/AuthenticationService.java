package by.daryazalevskaya.negotium.service;

import by.daryazalevskaya.negotium.entity.employee.Employee;
import by.daryazalevskaya.negotium.entity.employer.Employer;
import by.daryazalevskaya.negotium.repos.EmployeeRepos;
import by.daryazalevskaya.negotium.repos.EmployerRepos;
import by.daryazalevskaya.negotium.repos.UserRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private EmployeeRepos employeeRepos;

    @Autowired
    private EmployerRepos employerRepos;

    @Autowired
    private UserRepos userRepos;

    public Employee getAuthenticatedEmployee() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        long id=userRepos.findUserByUsername(username).getId();
        return employeeRepos.findEmployeeByUserId(id);
    }

    public Employer getAuthenticatedEmployer() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        long id=userRepos.findUserByUsername(username).getId();
        return employerRepos.findEmployerByUserId(id);
    }
}
