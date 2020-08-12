package net.dietsHelper.Diets.controllers;

import net.dietsHelper.Diets.security.details.UserDetailsImpl;
import net.dietsHelper.Diets.transfer.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MainController {

    @GetMapping(value = "/")
    public ResponseEntity mainPage(){
        return ResponseEntity.ok("done");
    }

    @GetMapping(value = "/index-signedIn")
    public String main(ModelMap model, Authentication authentication){
        if(authentication == null){
        return "redirect:/login";
    }
        UserDetailsImpl details = (UserDetailsImpl)authentication.getPrincipal();
        UserDto user = UserDto.from(details.getUser());
        model.addAttribute("user", user);
        return "index-signedIn";
    }
}
