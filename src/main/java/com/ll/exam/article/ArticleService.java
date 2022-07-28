package com.ll.exam.article;

import com.ll.exam.article.Dto.ArticleDto;

import java.util.List;

public class ArticleService {
    ArticleRepository articleRepository;

    public ArticleService() {
        articleRepository = new ArticleRepository();
    }

    public long write(String title, String body) {
        return articleRepository.write(title, body);
    }

    public List<ArticleDto> getList() {
        return articleRepository.getList();
    }

    public ArticleDto findById(long id) {
        return articleRepository.findById(id);
    }

    public long delete(long id) {
        return articleRepository.delete(id);
    }

    public long modify(long id, String title, String body) {
        return articleRepository.modify(id, title, body);
    }
}
