package com.genspark.TechBlog.controller;

import com.genspark.TechBlog.model.Tag;
import com.genspark.TechBlog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class TagsController {
    @Autowired
    private TagService tagService;

    @GetMapping("/tags")
    public Iterable<Tag> read() {
        return tagService.findAll();
    }

    @GetMapping("/tags/{id}")
    public Iterable<Tag> read(@PathVariable long id) {
        ArrayList<Long> idList = new ArrayList<>();
        idList.add(id);
        return tagService.findAllById(idList);
    }

    @PostMapping("/tags")
    public Tag add(@RequestBody Tag tag) {
        return tagService.save(tag);
    }

    @DeleteMapping("/tags/{id}")
    public void delete(@PathVariable long id) {
        tagService.deleteById(id);
    }
}
