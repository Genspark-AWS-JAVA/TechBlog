package com.genspark.TechBlog.service;

import com.genspark.TechBlog.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleService extends JpaRepository<Article, Long> {

    Iterable<Article> findAllByUsername(String username);

    Iterable<Article> findByContentOrTitleContains(String keyword1, String keyword2);

    Article findFirstById(long article_id);

    Article findFirstAllById(long id);
}
