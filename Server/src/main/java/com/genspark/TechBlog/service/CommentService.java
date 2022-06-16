package com.genspark.TechBlog.service;

import com.genspark.TechBlog.model.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentService extends CrudRepository<Comment, Long> {
    Iterable<Comment> findAllByArticleId(long article_id);

    void deleteByArticleId(long article_id);
}
