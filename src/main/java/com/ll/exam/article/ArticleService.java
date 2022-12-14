package com.ll.exam.article;

import com.ll.exam.article.Dto.ArticleDto;

import java.time.LocalDateTime;
import java.util.List;

public class ArticleService {
    ArticleRepository articleRepository;

    public ArticleService() {
        articleRepository = new ArticleRepository();
    }
    public long write(String title, String body, LocalDateTime createDate, LocalDateTime modifyDate) {
        return articleRepository.write(title, body, createDate, modifyDate);
    }

    public List<ArticleDto> findAll() {
        return articleRepository.getList();
    }

    public ArticleDto findById(long id) {
        return articleRepository.findById(id);
    }

    public long delete(long id) {
        return articleRepository.delete(id);
    }

    public long modify(long id, String title, String body, LocalDateTime modifyDate) {
        return articleRepository.modify(id, title, body, modifyDate);
    }

    public List<ArticleDto> findIdGreaterThan(long id) {
        return articleRepository.findIdGreaterThan(id);
    }

    public ArticleDto findBiggerId(long id) {
        return articleRepository.findBiggerId(id);
    }
}
