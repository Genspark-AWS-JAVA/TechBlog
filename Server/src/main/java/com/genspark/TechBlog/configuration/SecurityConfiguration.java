package com.genspark.TechBlog.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
    private static final String ENCODED_PASSWORD = "$2a$10$dFbpG0SAgkQ27SOyqpjlOeFK2s1x6GkepQDIn52TKT.6TB8cS.4rG";

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/articles").permitAll()
                .antMatchers("/login").permitAll()
                .anyRequest().authenticated().and().httpBasic()
                .and().csrf().disable().build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User.withUsername("user").password(ENCODED_PASSWORD).roles("USER").build();
        UserDetails admin = User.withUsername("admin").password(ENCODED_PASSWORD).roles("USER", "ADMIN").build();
        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
