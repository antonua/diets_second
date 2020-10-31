package net.dietsHelper.Diets.services;

import net.dietsHelper.Diets.repositories.UsersRepository;
import net.dietsHelper.Diets.forms.UserForm;
import net.dietsHelper.Diets.models.Role;
import net.dietsHelper.Diets.models.State;
import net.dietsHelper.Diets.models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Component
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void signUp(UserForm userForm) {

        String hashPassword = passwordEncoder.encode(userForm.getHashPassword());

        User user = User.builder()
                .firstName(userForm.getFirstName())
                .lastName(userForm.getLastName())
                .email(userForm.getEmail())
                .hashPassword(hashPassword)
                .login(userForm.getLogin())
                .role(Role.USER)
                .state(State.ACTIVE)
                .build();

        usersRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return usersRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long userId) {
        return usersRepository.findById(userId);
    }

    @Override
    public void deleteById(Long userId) {
        usersRepository.deleteById(userId);
    }
}
