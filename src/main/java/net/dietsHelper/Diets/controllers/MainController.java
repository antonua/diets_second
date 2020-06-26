package net.dietsHepler.Diets.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    @GetMapping(value = "/")
    public String main(Model model){
        model.addAttribute("message", "Hello index");
        return "index";
    }
}
