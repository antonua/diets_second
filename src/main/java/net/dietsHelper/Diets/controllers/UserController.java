package net.dietsHepler.Diets.controllers;

import net.dietsHepler.Diets.models.User;
import net.dietsHepler.Diets.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public String findAll(Model model){
        List<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "user-list";
    }



    @GetMapping("user-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        userRepository.delete(id);
        return "redirect:/users";
    }


}
