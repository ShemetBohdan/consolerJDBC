package com.example.consolerjdbc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class AutConfig extends WebSecurityConfigurerAdapter {

    private final DataSource dataSource;
    @Autowired
    public AutConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("bohdan")
                .password("{noop}1234")
                .authorities("ROLE_USER")
                .and()
                .withUser("bob")
                .password("{noop}qwerty")
                .authorities("ROLE_ADMIN");
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication()
//                .dataSource(dataSource)
//                .usersByUsernameQuery("SELECT user_name, password, enable FROM users WHERE user_name=?")
//                .authoritiesByUsernameQuery("SELECT user_name, authority FROM users_authorities WHERE user_name=?")
//                .passwordEncoder(new StandardPasswordEncoder("g2k3l1s1"));
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/animals")
//                .permitAll().and()
//                .antMatcher("/user")
//                .authorizeRequests();
//    }
}
