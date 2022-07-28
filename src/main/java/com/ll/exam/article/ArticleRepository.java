package com.ll.exam.article;

import com.ll.exam.article.Dto.ArticleDto;

import java.util.ArrayList;
import java.util.List;

public class ArticleRepository {
    private static List<ArticleDto> articleDtoList;
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
}
