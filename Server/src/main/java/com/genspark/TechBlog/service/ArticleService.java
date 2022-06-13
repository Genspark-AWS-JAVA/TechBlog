package com.genspark.TechBlog.service;

import com.genspark.TechBlog.model.Article;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleService extends CrudRepository<Article, Long> {

}
