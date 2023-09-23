package com.online.shop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.servlet.http.HttpServletResponse;

@Configuration
@Order(1)
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors() // Enable CORS
                .and()
                .authorizeRequests()
                .antMatchers("/api/images/upload").authenticated() // Secure this endpoint
                .anyRequest().permitAll()
                .and()
                .httpBasic().and()
                .csrf().disable() // Disable CSRF for testing
                .exceptionHandling().authenticationEntryPoint((request, response, authException) -> {
                    // Log authentication errors
                    System.out.println("Authentication error: " + authException.getMessage());
                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Authentication failed");
                })
                .and()
                .exceptionHandling().accessDeniedHandler((request, response, accessDeniedException) -> {
                    // Log authorization errors
                    System.out.println("Authorization error: " + accessDeniedException.getMessage());
                    response.sendError(HttpServletResponse.SC_FORBIDDEN, "Authorization failed");
                });
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("image_uploader").password(passwordEncoder().encode("image")).roles("USER");
        // Add more users as needed
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

