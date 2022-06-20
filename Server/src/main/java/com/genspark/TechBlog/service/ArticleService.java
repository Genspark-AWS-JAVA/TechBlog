package com.genspark.TechBlog.service;

import com.genspark.TechBlog.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleService extends JpaRepository<Article, Long> {

    Iterable<Article> findAllByUsername(String username);

    Article findFirstById(long article_id);

    Article findFirstAllById(long id);

    Iterable<Article> findByContentContainsOrTitleContains(String keyword, String keyword1);
}
