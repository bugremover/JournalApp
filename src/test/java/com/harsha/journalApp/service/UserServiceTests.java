package com.harsha.journalApp.service;

import com.harsha.journalApp.entity.User;
import com.harsha.journalApp.respository.UserRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTests {

    @Autowired
    private UserRepository userRepository;
    @ParameterizedTest
    @ValueSource(strings = {
            "Harsha",
            "Mars",
            "Sun",
            "Mavya"

    })
    public void testFindByUserName(String name){
       assertNotNull(userRepository.findByuserName(name),"failed for:"+ name);
    }
    @Disabled
    @ParameterizedTest
    @CsvSource({
        "1,1,2",
        "2,10,12",
        "3,3,9"

    })
    public void test(int a,int b,int expected){
        assertEquals(expected,a+b);
    }

}
