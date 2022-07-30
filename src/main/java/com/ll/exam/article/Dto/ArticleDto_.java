package com.ll.exam.article.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDto_ {
    private long id;
    private String title;
    private String body;
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;
}
