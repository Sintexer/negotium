package by.daryazalevskaya.negotium.repos;

import by.daryazalevskaya.negotium.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepos extends CrudRepository<User, Long>{
    User findUserByEmail(String email);
}
