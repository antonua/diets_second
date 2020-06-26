package net.dietsHelper.Diets.repositories;

import net.dietsHelper.Diets.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    List<User> findAllByFirstName(String firstName);
    Optional<User> findById(Long id);
    User delete(Long id);

    Optional<User> findOneByLogin(String login);
}
