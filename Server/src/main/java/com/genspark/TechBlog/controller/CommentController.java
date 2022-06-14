package com.genspark.TechBlog.controller;

import com.genspark.TechBlog.model.Comment;
import com.genspark.TechBlog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping("/comments")
    public Iterable<Comment> read() {
        return commentService.findAll();
    }

    @GetMapping("/comments/{id}")
    public Iterable<Comment> read(@PathVariable long id) {
        ArrayList<Long> idList = new ArrayList<>();
        idList.add(id);
        return commentService.findAllById(idList);
    }

//    @GetMapping("/comments/article/{id}")
//    public Iterable<Comment> readByArticle(@PathVariable long id) {
//        return commentService.findAllByArticleId(id);
//    }

    @PostMapping("/comments")
    public Comment add(@RequestBody Comment comment) {
        return commentService.save(comment);
    }

    @PutMapping("/comments")
    public Comment update(@RequestBody Comment comment) {
        return commentService.save(comment);
    }

}
