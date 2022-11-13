package com.jmcompany.dobaerang.domain.user;

import com.jmcompany.dobaerang.domain.post.model.Post;
import com.jmcompany.dobaerang.domain.user.model.User;
import com.jmcompany.dobaerang.domain.user.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

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

    @DisplayName(value = "User_Role Test")
    @Test
    void user_role(){
        userRepository.findAll().forEach(System.out::println);
    }

    @DisplayName("[Find] findByUsername")
    @Test
    void findByUsername(){
        String searchText = "user1";

        List<Post> posts = new ArrayList<>();

        Post post = Post.builder()
                .title("사랑이의 귀여움")
                .content("사랑이는 정말 귀엽다")
                .build();

        posts.add(post);

        User user = userRepository.findByUsername(searchText);
        user.setPosts(posts);
        userRepository.save(user);

        System.out.println(user);
    }

}