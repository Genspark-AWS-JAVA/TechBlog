package com.genspark.TechBlog.controller;

import com.genspark.TechBlog.model.Article;
import com.genspark.TechBlog.model.Tag;
import com.genspark.TechBlog.service.ArticleService;
import com.genspark.TechBlog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TagsController {
    @Autowired
    private TagService tagService;
    @Autowired
    private ArticleService articleService;

    @GetMapping("/tags")
    public Iterable<Tag> read() {
        return tagService.findAll();
    }

    @GetMapping("/tags/{value}")
    public Tag read(@PathVariable String value) {
        return tagService.findFirstByValue(value);
    }

    @PostMapping("/tags")
    public Tag add(@RequestBody Tag tag) {
        return tagService.save(tag);
    }

    @DeleteMapping("/tags/{value}")
    public void delete(@PathVariable String value) {
        tagService.deleteByValue(value);
    }

    @GetMapping("/tags/{value}/articles")
    public Iterable<Article> readByTag(@PathVariable String value) {
        return tagService.findFirstByValue(value).getArticles();
    }

    // add article to tag
    @PutMapping("/tags/{value}/articles/{article_id}")
    public Tag addArticle(@PathVariable String value, @PathVariable long article_id) {
        Tag tag = tagService.findFirstByValue(value);
        Article article = articleService.findFirstById(article_id);
        tag.addArticle(article);
        return tagService.save(tag);
    }

}
