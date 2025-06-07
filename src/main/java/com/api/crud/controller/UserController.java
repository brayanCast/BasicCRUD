package com.api.crud.controller;

import com.api.crud.models.UserModel;
import com.api.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ArrayList<UserModel> getUsers(){
        return this.userService.getUsers();
    }

    @PostMapping
    public UserModel saveUser(@RequestBody UserModel user){
        return this.userService.saveUser(user);
    }

    @GetMapping(path = "/{id}")
    public Optional<UserModel> getUserById(@PathVariable Long id) {
        return this.userService.getUserById(id);
    }

    @PutMapping(path = "/{id}")
    public UserModel updateUserById(@RequestBody UserModel request, @PathVariable("id") Long id){
        return this.userService.updateById(request, id);
    }

    @DeleteMapping("/{id}")

    public String deleteUserById(@PathVariable("id") Long id){
        boolean ok = this.userService.deleteUser(id);

        if (ok) {
            return "User with id " + id + " deleted successfully";
        }else {
            return "Error, It user with id" + id + " cannot be deleted";
        }

    }
}
