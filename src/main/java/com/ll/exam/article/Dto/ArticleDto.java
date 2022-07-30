package com.ll.exam.article.Dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDto {
    private long id;
    private String title;
    private String body;
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;
}
