package com.genspark.TechBlog.service;

import com.genspark.TechBlog.model.Tags;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagsService extends CrudRepository<Tags, Long> {

}
