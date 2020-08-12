package net.dietsHelper.Diets.controllers;

import net.dietsHelper.Diets.forms.UserForm;
import net.dietsHelper.Diets.models.User;
import net.dietsHelper.Diets.services.UsersService;
import net.dietsHelper.Diets.transfer.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static net.dietsHelper.Diets.transfer.UserDto.from;

@RestController
public class UserController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/users")
    public List<UserDto> getUsers(){
        return from(usersService.findAll());
    }



    @GetMapping("user-delete/{user-id}")
    public void deleteUser(@PathVariable("user-id") Long userId){
       usersService.deleteById(userId);
    }

    @GetMapping("/user/{user-id}")
    public Optional<User> getUser(@PathVariable("user-id") Long userId){
        return usersService.findById(userId);
    }

    @PostMapping("/users")
    public ResponseEntity<Object> addUser(@RequestBody UserForm  userForm){
        usersService.signUp(userForm);
        return ResponseEntity.ok().build();
    }
}
