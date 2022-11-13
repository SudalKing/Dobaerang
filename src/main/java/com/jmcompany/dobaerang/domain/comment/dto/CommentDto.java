package com.jmcompany.dobaerang.domain.comment.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
public class CommentDto {

    private Long id;
    private String content;

}
