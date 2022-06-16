package com.genspark.TechBlog.controller;

import com.genspark.TechBlog.model.Comment;
import com.genspark.TechBlog.service.ArticleService;
import com.genspark.TechBlog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;
    @Autowired
    private ArticleService articleService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/comments")
    public Iterable<Comment> read() {
        return commentService.findAll();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/comments/{id}")
    public Iterable<Comment> read(@PathVariable long id) {
        ArrayList<Long> idList = new ArrayList<>();
        idList.add(id);
        return commentService.findAllById(idList);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/articles/{article_id}/comments")
    public Iterable<Comment> readByArticle(@PathVariable(value = "article_id") long id) {
        return commentService.findAllByArticleId(id);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/articles/{article_id}/comments")
    public Comment add(@PathVariable(value = "article_id") long id, @RequestBody Comment comment) {
        comment.setArticle(articleService.findById(id).get());
        return commentService.save(comment);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/articles/{article_id}/comments")
    public Comment update(@PathVariable(value = "article_id") long id, @RequestBody Comment comment) {
        return commentService.save(comment);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/comments/{id}")
    public void delete(@PathVariable(value = "id") long id) {
        commentService.deleteById(id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/article/{article_id}/comments")
    public void deleteByArticle(@PathVariable(value = "article_id") long id) {
        commentService.deleteByArticleId(id);
    }

}
