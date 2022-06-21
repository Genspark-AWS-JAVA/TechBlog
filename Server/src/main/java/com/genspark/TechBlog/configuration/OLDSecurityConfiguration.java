package com.genspark.TechBlog.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.ldap.EmbeddedLdapServerContextSourceFactoryBean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


//@Configuration
//@EnableWebSecurity
public class OLDSecurityConfiguration {
//    private static final String ENCODED_PASSWORD = "$2a$10$dFbpG0SAgkQ27SOyqpjlOeFK2s1x6GkepQDIn52TKT.6TB8cS.4rG";

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(
                        request -> request
                                .anyRequest().authenticated()
//                                .antMatchers("/**").permitAll()
//                                .antMatchers(HttpMethod.GET, "/", "/**").permitAll()
//                                .antMatchers(HttpMethod.POST, "/articles").hasAuthority(Authorities.WRITE_ARTICLE.toString())
//                                .antMatchers(HttpMethod.PUT, "/articles/**").hasAuthority(Authorities.WRITE_ARTICLE.toString())
//                                .antMatchers(HttpMethod.DELETE, "/articles/**").hasAuthority(Authorities.DELETE_ARTICLE.toString())
//                                .antMatchers(HttpMethod.POST, "/comments").hasAuthority(Authorities.WRITE_ARTICLE.toString())
//                                .antMatchers(HttpMethod.PUT, "/comments/**").hasAuthority(Authorities.WRITE_ARTICLE.toString())
//                                .antMatchers(HttpMethod.DELETE, "/comments/**").hasAuthority(Authorities.DELETE_COMMENT.toString())
//                                .antMatchers(HttpMethod.POST, "/users").hasAuthority(Authorities.WRITE_USER.toString())
//                                .antMatchers(HttpMethod.PUT, "/users/**").hasAuthority(Authorities.WRITE_USER.toString())
//                                .antMatchers(HttpMethod.DELETE, "/users/**").hasAuthority(Authorities.DELETE_USER.toString())
                )
//                .httpBasic().and()
                .cors().disable()
                .csrf().disable().build();
//                .cors(Customizer.withDefaults())
//                .csrf((csrf) -> csrf.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))
//                .build();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() throws Exception {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("http://localhost:8080");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);
        return source;
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

//        @Bean
//        public DataSource dataSource() {
//            return new EmbeddedDatabaseBuilder()
//                    .setType(EmbeddedDatabaseType.H2)
//                    .addScript(JdbcDaoImpl.DEFAULT_USER_SCHEMA_DDL_LOCATION)
//                    .build();
//        }

//        @Bean
//        public UserDetailsManager users(DataSource dataSource) {
//            UserDetails user = User.withUsername("user")
//                    .password("$2a$10$iFB7/HA/21gkwD1Ug7ooOuwSkcUxvhv/YdPHldxMlCnwncKsWYpo.")
//                    .roles("USER")
//                    .build();
//            JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
//            users.createUser(user);
//            return users;
//        }


    @Bean
    public EmbeddedLdapServerContextSourceFactoryBean contextSourceFactoryBean() {
        EmbeddedLdapServerContextSourceFactoryBean contextSourceFactoryBean =
                EmbeddedLdapServerContextSourceFactoryBean.fromEmbeddedLdapServer();
        contextSourceFactoryBean.setPort(0);
        return contextSourceFactoryBean;
    }

//    @Bean
//    AuthenticationManager ldapAuthenticationManager(BaseLdapPathContextSource contextSource) {
//        LdapBindAuthenticationManagerFactory factory = new LdapBindAuthenticationManagerFactory(contextSource);
//        factory.setUserDnPatterns("uid={0},ou=people");
//        factory.setUserDetailsContextMapper(new PersonContextMapper());
//        return factory.createAuthenticationManager();
//    }

//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .ldapAuthentication()
//                .userDnPatterns("uid={0},ou=people")
//                .groupSearchBase("ou=groups")
//                .contextSource()
//                .url("ldap://localhost:8389/dc=springframework,dc=org")
//                .and()
//                .passwordCompare()
//                .passwordEncoder(new BCryptPasswordEncoder())
//                .passwordAttribute("userPassword");
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
