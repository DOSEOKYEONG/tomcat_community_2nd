package com.ll.exam.article;

import com.ll.exam.article.Dto.ArticleDto;
import com.ll.exam.article.Dto.ArticleDto_;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArticleRepository {
    private static List<ArticleDto> articleDtoList;
    private static List<ArticleDto_> articleDto_List;
    private static long lastId;

    static {
        articleDtoList = new ArrayList<>();
        lastId = 0;
    }
    public ArticleRepository() {
    }

    public long write(String title, String body) {
        long id = ++lastId;
        ArticleDto articleDto = new ArticleDto(id, title, body);
        String result = articleDto.toString();
        System.out.println(result);
        articleDtoList.add(articleDto);

        return id;
    }

    public List<ArticleDto> getList() {
        return articleDtoList;
    }

    public ArticleDto findById(long id) {
        for (ArticleDto articleDto : articleDtoList) {
            if (articleDto.getId() == id) {
                return articleDto;
            }
        }
        return null;
    }

    public long delete(long id) {
        ArticleDto articleDto = findById(id);
        if (articleDto == null) {
            return 0;
        }
        articleDtoList.remove(articleDto);
        return id;
    }

    public long modify(long id, String title, String body) {
        ArticleDto articleDto = findById(id);
        if (articleDto == null) {
            return 0;
        }
        articleDto.setTitle(title);
        articleDto.setBody(body);
        String result = articleDto.toString();
        System.out.println(result);

        return id;
    }

    public List<ArticleDto> findIdGreaterThan(long id) {
        return articleDtoList
                .stream()
                .filter(articleDto -> articleDto.getId() > id)
                .collect(Collectors.toList());

    }

//    public long write_(String title, String body, LocalDateTime createDate, LocalDateTime modifyDate) {
//        long id = ++lastId;
//        ArticleDto_ articleDto = new ArticleDto_(id, title, body, createDate, modifyDate);
//        String result = articleDto.toString();
//        System.out.println(result);
//        articleDto_List.add(articleDto);
//
//        return id;
//    }
}
