package com.jmcompany.dobaerang.domain.user;

import com.jmcompany.dobaerang.domain.role.Role;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User userSave(User user){
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user.setEnabled(true);

        Role role = new Role();
        role.setId(1l);

        user.getRoles().add(role);

        return userRepository.save(user);
    }

    public User adminSave(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(true);

        Role role = new Role();
        role.setId(2l);

        user.getRoles().add(role);

        return userRepository.save(user);
    }

}
