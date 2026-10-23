package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig 
{
    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity http) throws Exception 
    {
        http
            .csrf(csrf -> csrf.disable())

            .authorizeHttpRequests(auth -> auth

                .anyRequest().permitAll()

            );

            /*.sessionManagement(session ->
                    session.sessionCreationPolicy(
                            SessionCreationPolicy.IF_REQUIRED
                    )
            );*/

        return http.build();
    }
}
