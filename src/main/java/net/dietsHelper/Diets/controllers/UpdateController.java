package net.dietsHepler.Diets.controllers;

import net.dietsHepler.Diets.models.User;
import net.dietsHepler.Diets.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class UpdateController {

    private final UserRepository userRepository;

    @Autowired
    public UpdateController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("user-update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model){
        Optional<User> user = userRepository.findById(id);
        model.addAttribute("user", user);
        return "/user-update";
    }

    @PostMapping("/user-update")
    public String updateUser(User user){
        userRepository.save(user);
        return "redirect:/users";
    }
}
