package net.dietsHepler.Diets.controllers;

import net.dietsHepler.Diets.forms.UserForm;
import net.dietsHepler.Diets.services.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignUpController {

    private final SignUpService service;

    public SignUpController(SignUpService service) {
        this.service = service;
    }

    @GetMapping("/signUp")
    public String getSignUpPage(){
        return "signUp";
    }

    @PostMapping("/signUp")
    public String signUp(UserForm userForm){
        service.signUp(userForm);
        return "redirect:/login";
    }

}
