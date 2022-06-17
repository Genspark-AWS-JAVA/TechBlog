package com.genspark.TechBlog.service;

import com.genspark.TechBlog.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleService extends JpaRepository<Article, Long> {

}
