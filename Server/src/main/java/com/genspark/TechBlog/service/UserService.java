package com.genspark.TechBlog.service;

import com.genspark.TechBlog.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UserService extends CrudRepository<User, Long> {

    Iterable<User> findAllByUsername(String username);

    @Transactional
    void deleteByUsername(String username);

}
