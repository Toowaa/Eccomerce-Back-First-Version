package com.example.demo.auth;

/*


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;


@EnableWebSecurity

@Configuration
public class WebSecurityConfig  {


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return  http
            .csrf(csrf ->
                csrf .disable())
            .authorizeHttpRequests( authRequest ->
                authRequest
                    .requestMatchers("/auth/").permitAll()
                    .anyRequest().authenticated()
            )
            .build();
    }

}
*/