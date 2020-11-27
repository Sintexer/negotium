package by.daryazalevskaya.negotium.repos;

import by.daryazalevskaya.negotium.entity.employee.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepos extends CrudRepository<Employee, Long> {
}
