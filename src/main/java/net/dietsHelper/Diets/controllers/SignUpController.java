package net.dietsHelper.Diets.controllers;

import net.dietsHelper.Diets.forms.LoginForm;
import net.dietsHelper.Diets.services.UsersService;
import net.dietsHelper.Diets.forms.UserForm;
import net.dietsHelper.Diets.transfer.TokenDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class SignUpController {

   @Autowired
   private UsersService usersService;

    @GetMapping("/signUp")
    public String getSignUpPage(Model model){
        model.addAttribute("user", new UserForm());
        return "signUp";
    }

    @PostMapping("/signUp")
    public ResponseEntity<Object> addUser(@RequestBody UserForm  userForm){
        usersService.signUp(userForm);
        return ResponseEntity.ok().build();
    }

}
