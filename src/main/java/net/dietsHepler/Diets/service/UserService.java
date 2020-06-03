package net.dietsHepler.Diets.service;

import net.dietsHepler.Diets.model.User;

import java.util.List;

public interface UserService {

    User register(User user);

    List<User> getAll();

    User findByUsername(String usernname);

    User findById(Long id);

    void delete(Long id);

}
