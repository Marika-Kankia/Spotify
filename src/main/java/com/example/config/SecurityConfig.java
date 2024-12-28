package com.example.config;

import com.example.Security.JwtAuthFilter;
import com.example.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.AuthenticationEntryPoint;

@Configuration
public class SecurityConfig {

    private final JwtAuthFilter jwtAuthenticationFilter;
    private final AuthenticationEntryPoint unauthorizedHandler;
    private final UserServiceImpl userDetailsService;

    public SecurityConfig(JwtAuthFilter jwtAuthenticationFilter, AuthenticationEntryPoint unauthorizedHandler, UserServiceImpl userDetailsService) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
        this.unauthorizedHandler = unauthorizedHandler;
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        CsrfTokenRequestAttributeHandler csrfTokenHandler = new CsrfTokenRequestAttributeHandler();
        csrfTokenHandler.setCsrfRequestAttributeName("_csrf");

        http.csrf(csrf -> csrf
                .csrfTokenRequestHandler(csrfTokenHandler)
                .ignoringRequestMatchers(
                        new AntPathRequestMatcher("/user/register"),
                        new AntPathRequestMatcher("/user/login")
                )
        );

        http.authorizeHttpRequests(auth -> auth
                .requestMatchers(
                        new AntPathRequestMatcher("/user/register"),
                        new AntPathRequestMatcher("/user/login")
                ).permitAll()
                .anyRequest().authenticated()
        );

        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        http.exceptionHandling(exceptionHandling ->
                exceptionHandling.authenticationEntryPoint(unauthorizedHandler)
        );

        return http.build();
    }

    // Bean for password encoder
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Bean for authentication manager
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }
}
