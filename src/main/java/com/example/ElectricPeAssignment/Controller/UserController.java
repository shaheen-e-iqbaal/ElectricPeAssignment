package com.example.ElectricPeAssignment.Controller;


import com.example.ElectricPeAssignment.Entities.User;
import com.example.ElectricPeAssignment.Service.UserService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    UserService userService;
    public UserController(UserService userService){
        this.userService = userService;
    }

    //EndPoint to Create User
    @PostMapping(path = "/creatuser")
    public String createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    //EndPoint to Login User
    @GetMapping(path = "/login")
    public String login(@RequestParam String emailId,
                        @RequestParam String password){
        return userService.login(emailId, password);
    }

    //Endpoint to Get User
    @GetMapping(path = "/get/{userId}")
    public User getUser(@PathVariable int userId){
        return userService.getUser(userId);
    }
}
