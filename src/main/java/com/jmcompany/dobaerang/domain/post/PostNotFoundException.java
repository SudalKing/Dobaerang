package com.jmcompany.dobaerang.domain.post;

public class PostNotFoundException extends RuntimeException{

    public PostNotFoundException(Long id){
        super("존재하지 않는 글입니다!( " + id + " )");
    }
}
