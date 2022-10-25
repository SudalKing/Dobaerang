package com.jmcompany.dobaerang.domain.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private EntityManager entityManager;

    @DisplayName(value = "UserService save Test")
    @Test
    void saveServiceTest(){

        User user = new User();
        user.setUsername("admin");
        user.setPassword("0000");
        userService.adminSave(user);

        User user1 = new User();
        user1.setUsername("user1");
        user1.setPassword("1111");
        userService.userSave(user1);

        userRepository.findAll().forEach(System.out::println);
    }

}