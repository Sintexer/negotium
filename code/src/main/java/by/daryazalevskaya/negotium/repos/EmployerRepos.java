package by.daryazalevskaya.negotium.repos;

import by.daryazalevskaya.negotium.entity.employer.Employer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployerRepos extends CrudRepository<Employer, Long> {
}
