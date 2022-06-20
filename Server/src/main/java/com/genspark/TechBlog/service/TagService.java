package com.genspark.TechBlog.service;

import com.genspark.TechBlog.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface TagService extends JpaRepository<Tag, Long> {

    @Transactional
    void deleteByValue(String value);

    Tag findFirstByValue(String value);

}
