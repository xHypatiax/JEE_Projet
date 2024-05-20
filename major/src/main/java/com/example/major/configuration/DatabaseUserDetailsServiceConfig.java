package com.example.major.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;

@Configuration
public class DatabaseUserDetailsServiceConfig {

    @Bean
    public UserDetailsService databaseUserDetailsService(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }


}
