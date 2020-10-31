package net.dietsHelper.Diets.controllers;


import net.dietsHelper.Diets.models.Diet;
import net.dietsHelper.Diets.services.DietsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
public class DietController {


    @Autowired
    private DietsService dietsService;


    @GetMapping("/diets/{typeName}")
    public Optional<Diet> getDietByTypeName(@PathVariable("typeName") String typeName){
        return dietsService.findRandomRecipe(typeName);
    }

    @GetMapping("/diets-name/{diet-name}")
    public StringBuffer getDietByName(@PathVariable("diet-name") String dietName){
        System.out.println(dietsService.findByName(dietName));
        return dietsService.findByName(dietName);
    }

}
