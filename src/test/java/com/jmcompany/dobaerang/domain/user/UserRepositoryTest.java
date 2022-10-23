package com.jmcompany.dobaerang.domain.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @DisplayName(value = "User Domain Test")
    @Test
    void user(){
        User user1 = new User();
        user1.setUsername("user1");
        user1.setPassword("1111");
        user1.setEnabled(true);
        userRepository.save(user1);

        userRepository.findAll().forEach(System.out::println);
    }

}