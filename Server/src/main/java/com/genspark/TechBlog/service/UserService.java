package com.genspark.TechBlog.service;

import com.genspark.TechBlog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UserService extends JpaRepository<User, Long> {

    Iterable<User> findAllByUsername(String username);

    @Transactional
    void deleteByUsername(String username);

    User findFirstByUsername(String username);
}
