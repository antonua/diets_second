package net.dietsHelper.Diets.services;

import net.dietsHelper.Diets.forms.UserForm;
import net.dietsHelper.Diets.models.User;

import java.util.List;
import java.util.Optional;

public interface UsersService {
    void signUp(UserForm userForm);

    List<User> findAll();

    Optional<User> findById(Long userId);
    void deleteById(Long userId);
}
