package com.harsha.journalApp.controller;

import com.harsha.journalApp.entity.User;
import com.harsha.journalApp.respository.UserRepository;
import com.harsha.journalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    UserRepository userRepository;


    //upadting password through username
    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody User user ){
        Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
        String userName=authentication.getName();
    User UserInDb=userService.findByUserName(userName);
    if(UserInDb != null){
        UserInDb.setUserName(user.getUserName());
        UserInDb.setPassword(user.getPassword());
        userService.saveNewEntry(UserInDb);
    }
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping
    public ResponseEntity<?> deleteUserById(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        userRepository.deleteByUserName(authentication.getName());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
