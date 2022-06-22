package com.genspark.TechBlog.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(org.springframework.security.config.annotation.web.builders.HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/**").permitAll()
//                .antMatchers(HttpMethod.GET, "/", "/**").permitAll()
//                .antMatchers(HttpMethod.POST, "/articles").hasAuthority(Authorities.WRITE_ARTICLE.toString())
//                .antMatchers(HttpMethod.PUT, "/articles/**").hasAuthority(Authorities.WRITE_ARTICLE.toString())
//                .antMatchers(HttpMethod.DELETE, "/articles/**").hasAuthority(Authorities.DELETE_ARTICLE.toString())
//                .antMatchers(HttpMethod.POST, "/comments").hasAuthority(Authorities.WRITE_ARTICLE.toString())
//                .antMatchers(HttpMethod.PUT, "/comments/**").hasAuthority(Authorities.WRITE_ARTICLE.toString())
//                .antMatchers(HttpMethod.DELETE, "/comments/**").hasAuthority(Authorities.DELETE_COMMENT.toString())
//                .antMatchers(HttpMethod.POST, "/users").hasAuthority(Authorities.WRITE_USER.toString())
//                .antMatchers(HttpMethod.PUT, "/users/**").hasAuthority(Authorities.WRITE_USER.toString())
//                .antMatchers(HttpMethod.DELETE, "/users/**").hasAuthority(Authorities.DELETE_USER.toString())
//                .anyRequest().authenticated()
//                .and()
//                .httpBasic()
                .and()
                .csrf().disable()
                .cors().disable();
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("user")
//                .password("$2a$10$iFB7/HA/21gkwD1Ug7ooOuwSkcUxvhv/YdPHldxMlCnwncKsWYpo.")
//                .authorities(Authorities.WRITE_ARTICLE.toString())
//                .and()
//                .withUser("admin")
//                .password("$2a$10$iFB7/HA/21gkwD1Ug7ooOuwSkcUxvhv/YdPHldxMlCnwncKsWYpo.")
//                .authorities(Authorities.WRITE_ARTICLE.toString(), Authorities.DELETE_COMMENT.toString(),
//                        Authorities.DELETE_ARTICLE.toString(), Authorities.WRITE_USER.toString(),
//                        Authorities.DELETE_USER.toString()).and()
//                .withUser("admin@genspark.com")
//                .password("$2a$10$iFB7/HA/21gkwD1Ug7ooOuwSkcUxvhv/YdPHldxMlCnwncKsWYpo.")
//                .authorities(Authorities.WRITE_ARTICLE.toString(), Authorities.DELETE_COMMENT.toString(),
//                        Authorities.DELETE_ARTICLE.toString(), Authorities.WRITE_USER.toString(),
//                        Authorities.DELETE_USER.toString());
//    }

//        @Override
//    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
////        auth.jdbcAuthentication()
////                .dataSource(dataSource)
////                .usersByUsernameQuery("SELECT username, password, enabled FROM users WHERE username = ?")
////                .authoritiesByUsernameQuery("SELECT username, authority FROM authorities WHERE username = ?");
//        auth.ldapAuthentication()
//                .userDnPatterns("uid={0},ou=people,dc=springframework,dc=org")
//                .groupSearchBase("ou=groups,dc=springframework,dc=org")
//                .contextSource()
//                .url("ldap://localhost:8389/dc=springframework,dc=org")
//                .and()
//                .passwordCompare();
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
