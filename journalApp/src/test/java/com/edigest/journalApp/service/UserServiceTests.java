package com.edigest.journalApp.service;

import com.edigest.journalApp.entity.User;
import com.edigest.journalApp.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTests {

    @Autowired
    private UserRepository userRepository ;

    @BeforeEach
    public void setUp(){

    }

//  @Disabled // to make this test disable
    @Test
    public void findByUserName(){
        assertNotNull(userRepository.findByUserName("ram"));
    }

    @Test
    public void findJornalEntries(){
        User user = userRepository.findByUserName("ram");
        assertTrue(!user.getJournalEntries().isEmpty());
    }

    @ParameterizedTest
    @CsvSource({
            "ram",
            "sham",
            "akshay"
    })
    public void findByUserName(String name){
        assertNotNull(userRepository.findByUserName(name),"failed for => "+name);
    }

    @ParameterizedTest
    @CsvSource({
            "1,1,2",
            "2,10,12",
            "2,5,8"
    })
    public void test(int a , int b , int expected){
        assertEquals(expected , a+b);
    }
}
