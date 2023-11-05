package com.igor.payment.core.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig{
    @Value("${raspay.security.client.username}")
    private String username;

    @Value("${raspay.security.client.password}")
    private String password;

    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        PasswordEncoder pass = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        UserDetails admin = User.withUsername(username)
                .password(pass.encode(password))
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(admin);
    }
}
