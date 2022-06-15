package com.genspark.TechBlog.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
//    private static final String ENCODED_PASSWORD = "$2a$10$dFbpG0SAgkQ27SOyqpjlOeFK2s1x6GkepQDIn52TKT.6TB8cS.4rG";

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(
                request -> request
                        .antMatchers(HttpMethod.GET, "/", "/**").permitAll()
                        .antMatchers(HttpMethod.POST, "/articles").hasAuthority(Authorities.WRITE_ARTICLE.toString())
                        .antMatchers(HttpMethod.PUT, "/articles/**").hasAuthority(Authorities.WRITE_ARTICLE.toString())
                        .antMatchers(HttpMethod.DELETE, "/articles/**").hasAuthority(Authorities.DELETE_ARTICLE.toString())
                        .antMatchers(HttpMethod.POST, "/comments").hasAuthority(Authorities.WRITE_ARTICLE.toString())
                        .antMatchers(HttpMethod.PUT, "/comments/**").hasAuthority(Authorities.WRITE_ARTICLE.toString())
                        .antMatchers(HttpMethod.DELETE, "/comments/**").hasAuthority(Authorities.DELETE_COMMENT.toString())
                        .antMatchers(HttpMethod.POST, "/users").hasAuthority(Authorities.WRITE_USER.toString())
                        .antMatchers(HttpMethod.PUT, "/users/**").hasAuthority(Authorities.WRITE_USER.toString())
                        .antMatchers(HttpMethod.DELETE, "/users/**").hasAuthority(Authorities.DELETE_USER.toString())
        ).httpBasic().and().csrf().disable().build();
//                .authorizeRequests()
//                .antMatchers("/").permitAll()
//                .antMatchers(HttpMethod.POST, "/articles").hasAnyRole("ADMIN", "USER")
//                .antMatchers(HttpMethod.PUT, "/articles").hasAnyRole("ADMIN", "USER")
//                .antMatchers(HttpMethod.DELETE, "/articles**").hasRole("ADMIN")
//                .antMatchers(HttpMethod.GET, "/articles**").permitAll()
//                .antMatchers("/login").permitAll()
//                .antMatchers("/register").permitAll()
//                .and().httpBasic()
//                .and().cors().and().csrf().disable()
//                .build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User.withUsername("user")
                .password("$2a$10$iFB7/HA/21gkwD1Ug7ooOuwSkcUxvhv/YdPHldxMlCnwncKsWYpo.")
                .authorities(Authorities.WRITE_ARTICLE.toString()).build();
        UserDetails admin = User.withUsername("admin")
                .password("$2a$10$iFB7/HA/21gkwD1Ug7ooOuwSkcUxvhv/YdPHldxMlCnwncKsWYpo.")
                .authorities(Authorities.WRITE_ARTICLE.toString(), Authorities.DELETE_COMMENT.toString(),
                        Authorities.DELETE_ARTICLE.toString(), Authorities.WRITE_USER.toString(),
                        Authorities.DELETE_USER.toString()).build();
        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
