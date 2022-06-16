package com.genspark.TechBlog.controller;

import com.genspark.TechBlog.model.Article;
import com.genspark.TechBlog.model.User;
import com.genspark.TechBlog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {
    @Autowired
    UserService userService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/users")
    public Iterable<User> read() {
        return userService.findAll();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/users/{username}")
    public Iterable<User> read(@PathVariable String username) {
        return userService.findAllByUsername(username);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/users/{username}/articles")
    public Iterable<Article> readByArticle(@PathVariable(value = "username") String username) {
        return userService.findAllByUsername(username).iterator().next().getArticles();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/users")
    public User add(@RequestBody User user) {
        return userService.save(user);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/users/{username}")
    public User update(@PathVariable String username, @RequestBody User user) {
        Iterable<User> users = userService.findAllByUsername(username);
        if (users.iterator().hasNext()) {
            User userToUpdate = users.iterator().next();
            user.setId(userToUpdate.getId());
            user.setUsername(userToUpdate.getUsername());
            userService.save(user);
            return userToUpdate;
        }
        return null;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/users/{username}")
    public void delete(@PathVariable String username) {
        userService.deleteByUsername(username);
    }

}
