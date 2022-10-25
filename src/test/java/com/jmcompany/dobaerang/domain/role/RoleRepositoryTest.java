package com.jmcompany.dobaerang.domain.role;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RoleRepositoryTest {

    @Autowired
    private RoleRepository roleRepository;

    @DisplayName("Role Domain Test")
    @Test
    void role(){
        Role role1 = new Role();
        role1.setType("ROLE_USER");

        Role role2 = new Role();
        role2.setType("ROLE_ADMIN");

        roleRepository.save(role1);
        roleRepository.save(role2);

        roleRepository.findAll().forEach(System.out::println);
    }

}