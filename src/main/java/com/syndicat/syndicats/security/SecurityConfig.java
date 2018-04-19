package com.syndicat.syndicats.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
@Autowired
private DataSource dataSource;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

/*
        auth.inMemoryAuthentication().withUser("admin").password("admin").roles("USER","ADMIN");
        auth.inMemoryAuthentication().withUser("user").password("user").roles("USER");*/


 /*auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery("select login , pass , active login, active  ");
*/
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin();


    }

}
