package com.pets.pet.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                .csrf(csrf -> csrf.disable()) // Desactiva CSRF si usas JWT
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.POST, "users").permitAll()
                        .requestMatchers(HttpMethod.POST, "auth/authenticate").permitAll()
                        .requestMatchers(HttpMethod.POST, "auth/refresh-token").permitAll()
                        .requestMatchers(HttpMethod.GET, "users").permitAll()
                        .requestMatchers(HttpMethod.GET, "pets").permitAll()
                        .requestMatchers(HttpMethod.POST, "pets").permitAll()
                        .requestMatchers(HttpMethod.GET, "pets/{id}").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "pets/{id}").permitAll()
                        .requestMatchers(HttpMethod.PATCH, "pets/{id}").permitAll()
                        .requestMatchers(HttpMethod.GET, "diets").permitAll()
                        .requestMatchers(HttpMethod.GET, "medications").permitAll()
                        .requestMatchers(HttpMethod.GET, "vaccines").permitAll()

                );

        return http.build();
    }

    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:17913"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList("authorization", "content-type"));
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
