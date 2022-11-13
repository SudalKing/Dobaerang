package com.jmcompany.dobaerang.domain.user.repository;

import com.jmcompany.dobaerang.domain.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
