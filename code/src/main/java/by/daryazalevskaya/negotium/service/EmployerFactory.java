package by.daryazalevskaya.negotium.service;

import by.daryazalevskaya.negotium.controller.RegistrationController;
import by.daryazalevskaya.negotium.entity.User;
import by.daryazalevskaya.negotium.entity.employer.Employer;
import by.daryazalevskaya.negotium.repos.EmployerRepos;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployerFactory {

    private static final Logger logger = LogManager.getLogger(EmployerFactory.class);

    @Autowired
    private EmployerRepos repos;

    public void saveEmployee(User user) {
        Employer employer=new Employer();
        employer.setUser(user);
        logger.debug(user);
        repos.save(employer);
    }
}
