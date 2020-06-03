package net.dietsHepler.Diets.service.impl;

import lombok.extern.slf4j.Slf4j;
import net.dietsHepler.Diets.model.Role;
import net.dietsHepler.Diets.model.Status;
import net.dietsHepler.Diets.model.User;
import net.dietsHepler.Diets.repository.RoleRepository;
import net.dietsHepler.Diets.repository.UserRepository;
import net.dietsHepler.Diets.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public User findByUsername(String usernname) {
        User result = userRepository.findByUsername(usernname);
        log.info("IN findByUsername - user: {} found by username: {}", result, usernname);
        return result;
    }

    @Override
    public User findById(Long id){
        User result = userRepository.findById(id).orElse(null);

        if(result == null){
            log.warn("IN findById - no user found by id: {}", id);
            return null;
        }

        log.info("IN findById - user: {} found by id: {}", result);
        return result;
    }

    @Override
    public List<User> getAll(){
        List<User> result = userRepository.findAll();
        log.info("IN getall - {} users found", result.size());
        return result;
    }

    @Override
    public User register(User user){
        Role roleUser = roleRepository.findByName("ROLE_USER");
        List<Role> userRoles = new ArrayList<>();
        userRoles.add(roleUser);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(userRoles);
        user.setStatus(Status.ACTIVE);

        User registeredUser = userRepository.save(user);

        log.info("IN register - user: {} successfully registered", registeredUser);
        return registeredUser;
    }

    @Override
    public void delete(Long id){

        userRepository.deleteById(id);
        log.info("IN delete - user with id: {} successfully deleted");
    }
}
