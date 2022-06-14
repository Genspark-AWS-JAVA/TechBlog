package com.genspark.TechBlog.controller;

import com.genspark.TechBlog.model.Tags;
import com.genspark.TechBlog.service.TagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class TagsController {
    @Autowired
    private TagsService tagsService;

    @GetMapping("/tags")
    public Iterable<Tags> read() {
        return tagsService.findAll();
    }

    @GetMapping("/tags/{id}")
    public Iterable<Tags> read(@PathVariable long id) {
        ArrayList<Long> idList = new ArrayList<>();
        idList.add(id);
        return tagsService.findAllById(idList);
    }

    @PostMapping("/tags")
    public Tags add(@RequestBody Tags tags) {
        return tagsService.save(tags);
    }

    @DeleteMapping("/tags/{id}")
    public void delete(@PathVariable long id) {
        tagsService.deleteById(id);
    }
}
