package com.genspark.TechBlog.controller;

import com.genspark.TechBlog.model.Article;
import com.genspark.TechBlog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/")
    public Iterable<Article> readHome() {
        return articleService.findAll();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/articles")
    public Iterable<Article> read() {
        return articleService.findAll();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/articles/{id}")
    public Iterable<Article> read(@PathVariable long id) {
        ArrayList<Long> idList = new ArrayList<>();
        idList.add(id);
        return articleService.findAllById(idList);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/articles")
    public Article update(@RequestBody Article article) {
        return articleService.save(article);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/articles")
    public Article add(@RequestBody Article article) {
        return articleService.save(article);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/articles/{id}")
    public void delete(@PathVariable long id) {
        articleService.deleteById(id);
    }

}
