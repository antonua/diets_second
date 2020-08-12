package net.dietsHelper.Diets.controllers;

import net.dietsHelper.Diets.forms.LoginForm;
import net.dietsHelper.Diets.services.LoginService;
import net.dietsHelper.Diets.transfer.TokenDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<TokenDto> login(@RequestBody LoginForm loginForm){
        return ResponseEntity.ok(loginService.login(loginForm));
    }
}
