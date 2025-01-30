package com.harsha.journalApp.service;

import com.harsha.journalApp.respository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import static org.mockito.Mockito.*;
@SpringBootTest
public class UserDetailsServiceImplTests {


    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @MockBean
    private UserRepository userRepository;
    @Test
    void loadUserByUsernameTest(){
        when(userRepository.findByuserName(ArgumentMatchers.anyString())).thenReturn((com.harsha.journalApp.entity.User) User.builder().username("Harsha").password("adlfjkaldjkf").build());
        UserDetails Harsha=userDetailsService.loadUserByUsername("Harsha");


    }
}
