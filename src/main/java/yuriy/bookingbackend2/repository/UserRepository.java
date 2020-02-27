package yuriy.bookingbackend2.repository;

import org.springframework.data.repository.CrudRepository;
import yuriy.bookingbackend2.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
    public User findByLogin(String login);
}
