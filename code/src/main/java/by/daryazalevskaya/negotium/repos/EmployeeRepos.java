package by.daryazalevskaya.negotium.repos;

import by.daryazalevskaya.negotium.entity.employee.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepos extends CrudRepository<Employee, Long> {
    Employee findEmployeeByUserId(Long id);
}
