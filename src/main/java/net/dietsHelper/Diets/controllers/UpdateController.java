package net.dietsHelper.Diets.controllers;

import net.dietsHelper.Diets.models.User;
import net.dietsHelper.Diets.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class UpdateController {

    private final UsersRepository usersRepository;

    @Autowired
    public UpdateController(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @GetMapping("user-update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model){
        Optional<User> user = usersRepository.findById(id);
        model.addAttribute("user", user);
        return "/user-update";
    }

    @PostMapping("/user-update")
    public String updateUser(User user){
        usersRepository.save(user);
        return "redirect:/users";
    }
}
