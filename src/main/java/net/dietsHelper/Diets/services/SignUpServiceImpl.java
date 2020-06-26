package net.dietsHelper.Diets.services.impl;

import net.dietsHelper.Diets.repositories.UserRepository;
import net.dietsHelper.Diets.services.SignUpService;
import net.dietsHelper.Diets.forms.UserForm;
import net.dietsHelper.Diets.models.Role;
import net.dietsHelper.Diets.models.State;
import net.dietsHelper.Diets.models.User;

import org.springframework.beans.factory.annotation.Autowired;

public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
   // private PasswordEncoder passwordEncoder;




    @Override
    public void signUp(UserForm userForm) {
       // String hashPassword = passwordEncoder.encode(userForm.getPassword());

        User user = User.builder()
                .firstName(userForm.getFirstName())
                .lastName(userForm.getLastName())
                .email(userForm.getEmail())
                //.hashPassword(hashPassword)
                .login(userForm.getLogin())
                .role(Role.USER)
                .state(State.ACTIVE)
                .build();

        userRepository.save(user);
    }
}
