package by.daryazalevskaya.negotium.repos;

import by.daryazalevskaya.negotium.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepos extends CrudRepository<User, Long>{
    User findUserByUsername(String username);
}
