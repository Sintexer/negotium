package by.daryazalevskaya.negotium.service;

import by.daryazalevskaya.negotium.entity.User;
import by.daryazalevskaya.negotium.entity.employee.Employee;
import by.daryazalevskaya.negotium.repos.EmployeeRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeFactory {

    @Autowired
    private EmployeeRepos repos;

    public void saveEmployee(User user) {
        Employee employee=new Employee();
        employee.setUser(user);
        repos.save(employee);
    }
}
