package net.dietsHelper.Diets.controllers;

import net.dietsHelper.Diets.services.UsersService;
import net.dietsHelper.Diets.forms.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignUpController {

   @Autowired
   private UsersService service;

    @GetMapping("/signUp")
    public String getSignUpPage(Model model){
        model.addAttribute("user", new UserForm());
        return "signUp";
    }

    @PostMapping("/signUp")
    public String signUp(UserForm userForm){
        service.signUp(userForm);
        return "redirect:/login";
    }

}
