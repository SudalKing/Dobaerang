package com.jmcompany.dobaerang.domain.comment.validator;

import com.jmcompany.dobaerang.domain.comment.model.Comment;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.thymeleaf.util.StringUtils;

public class CommentValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Comment.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Comment comment = (Comment) target;
        if(StringUtils.isEmpty(comment.getContent())){
            errors.rejectValue("content", "key", "내용을 입력하세요");
        }
    }
}
