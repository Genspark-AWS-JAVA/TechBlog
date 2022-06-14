package com.genspark.TechBlog.service;

import com.genspark.TechBlog.model.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagService extends CrudRepository<Tag, Long> {

}
