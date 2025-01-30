package com.harsha.journalApp.controller;

import com.harsha.journalApp.entity.User;
import com.harsha.journalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class PublicController {
    @Autowired
    public UserService userService;
    @GetMapping("health-check")
    public  String healthcheck(){
        return "OK";
    }
    @PostMapping("/create-user")
    public void createUser(@RequestBody User user){
        userService.saveNewEntry(user);
    }
}
