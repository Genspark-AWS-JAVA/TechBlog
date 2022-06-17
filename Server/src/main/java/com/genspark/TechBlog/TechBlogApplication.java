package com.genspark.TechBlog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * a Tech Blog web service application
 */
@SpringBootApplication
public class TechBlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(TechBlogApplication.class, args);
    }

}
