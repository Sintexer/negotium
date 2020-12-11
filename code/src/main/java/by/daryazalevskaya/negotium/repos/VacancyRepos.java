package by.daryazalevskaya.negotium.repos;

import by.daryazalevskaya.negotium.entity.employer.Vacancy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VacancyRepos extends CrudRepository<Vacancy, Long> {
    List<Vacancy> findVacanciesByEmployerId(Long id);
}
