package com.genspark.TechBlog.service;

import com.genspark.TechBlog.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserService extends CrudRepository<User, Long> {

}
