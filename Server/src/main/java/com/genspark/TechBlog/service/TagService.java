package com.genspark.TechBlog.service;

import com.genspark.TechBlog.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagService extends JpaRepository<Tag, Long> {

}
