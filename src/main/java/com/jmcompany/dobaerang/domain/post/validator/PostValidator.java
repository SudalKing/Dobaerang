package com.jmcompany.dobaerang.domain.post.validator;

import com.jmcompany.dobaerang.domain.post.model.Post;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.thymeleaf.util.StringUtils;

@Component
public class PostValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Post.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Post post = (Post) target;
        if(StringUtils.isEmpty(post.getContent())){
            errors.rejectValue("content", "key", "내용을 입력하세요");
        }
    }
}
