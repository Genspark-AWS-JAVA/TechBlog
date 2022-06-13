package com.genspark.TechBlog.controller;

import com.genspark.TechBlog.model.User;
import com.genspark.TechBlog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/users")
    public Iterable<User> read() {
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public Iterable<User> read(@PathVariable long id) {
        ArrayList<Long> idList = new ArrayList<>();
        idList.add(id);
        return userService.findAllById(idList);
    }

    @PostMapping("/users")
    public User add(@RequestBody User user) {
        return userService.save(user);
    }

    @PutMapping("/users")
    public User update(@RequestBody User user) {
        return userService.save(user);
    }

    @DeleteMapping("/users/{id}")
    public void delete(@PathVariable long id) {
        userService.deleteById(id);
    }

}
