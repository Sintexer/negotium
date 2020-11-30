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

//    private static AuthenticationService service;
//
//    private AuthenticationService() {
//    }
//
//    public static AuthenticationService getService() {
//        if (service==null) {
//            service=new AuthenticationService();
//        }
//
//        return service;
//    }

    @Autowired
    private EmployeeRepos employeeRepos;

    @Autowired
    private EmployerRepos employerRepos;

    @Autowired
    private UserRepos userRepos;

    public Employee getAuthentithicatedEmployee() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        long id=userRepos.findUserByUsername(username).getId();
        return employeeRepos.findEmployeeByUserId(id);
    }

    public Employer getAuthentithicatedEmployer() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        long id=userRepos.findUserByUsername(username).getId();
        return employerRepos.findEmployerByUserId(id);
    }
}
