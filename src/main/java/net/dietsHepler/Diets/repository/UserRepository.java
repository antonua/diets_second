package net.dietsHepler.Diets.repository;

import net.dietsHepler.Diets.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String name);
}
