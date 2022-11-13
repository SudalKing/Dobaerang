package com.jmcompany.dobaerang.domain.post;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostRepositoryTest {

    @Autowired
    private PostRepository postRepository;

    @DisplayName("[Create] Post")
    @Test
    void post(){
        postRepository.save(givenPost());

        postRepository.findAll().forEach(System.out::println);
    }

    @DisplayName("[Find] Title or Content")
    @Test
    void findByTitleContainingOrContentContainingTest(){
        String titleSearchText = "JPA";
        String contentSearchText2 = "해보자";

        Page<Post> postList = postRepository.findByTitleContainingOrContentContaining(titleSearchText, contentSearchText2, null);

        postList.forEach(System.out::println);
    }

    @DisplayName("[Mapping] With User")
    @Test
    void userMapping(){

    }

    public Post givenPost(){
        Post post = Post.builder()
                .title("Spring annotation 공부")
                .content("annotation 공부해보자!")
                .build();

        return post;
    }

    @DisplayName("[Method] FindAllBy(Title and Content)Containing")
    @Test
    public void methodTest1(){
        List<Post> post = postRepository.findAllByTitleContaining("뻘글");

        List<Post> post2 = postRepository.findAllByContentContaining("2");

        post.forEach(System.out::println);
        System.out.println("===============================");
        post2.forEach(System.out::println);

    }

}