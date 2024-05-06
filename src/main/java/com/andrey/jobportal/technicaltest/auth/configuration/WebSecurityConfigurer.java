package com.andrey.jobportal.technicaltest.auth.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.andrey.jobportal.technicaltest.applicationuser.ApplicationUserService;
import com.andrey.jobportal.technicaltest.auth.jwt.JwtAuthenticationEntryPoint;
import com.andrey.jobportal.technicaltest.auth.jwt.JwtAuthenticationTokenFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfigurer {
        private final ApplicationUserService userDetailsService;
        private final JwtAuthenticationEntryPoint unauthorizedHandler;

        @Bean
        JwtAuthenticationTokenFilter authenticationTokenFilter() {
                return new JwtAuthenticationTokenFilter();
        }

        @Bean
        BCryptPasswordEncoder bCryptPasswordEncoder() {
                return new BCryptPasswordEncoder(12);
        }

        @Bean
        AuthenticationManager authenticationManagerBean(HttpSecurity httpSecurity) throws Exception {
                AuthenticationManagerBuilder authenticationManagerBuilder = httpSecurity
                                .getSharedObject(AuthenticationManagerBuilder.class);
                authenticationManagerBuilder.userDetailsService(this.userDetailsService)
                                .passwordEncoder(this.bCryptPasswordEncoder());

                return authenticationManagerBuilder.build();
        }

        @Bean
        SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                http.cors(cors -> cors.disable())
                                .csrf(csrf -> csrf.disable())
                                .exceptionHandling(
                                                exceptionHandling -> exceptionHandling
                                                                .authenticationEntryPoint(unauthorizedHandler))
                                .sessionManagement(
                                                sessionManagement -> sessionManagement
                                                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                                .authorizeHttpRequests(
                                                request -> request.requestMatchers("/register").permitAll())
                                .authorizeHttpRequests(
                                                request -> request.requestMatchers("/tokens").permitAll())
                                .authorizeHttpRequests(
                                                request -> request.anyRequest().authenticated());

                http.addFilterBefore(authenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
                return http.build();
        }

        @Bean
        WebSecurityCustomizer webSecurityCustomizer() {
                return (web) -> web.ignoring().requestMatchers("/swagger-ui/**", "/v3/api-docs/**");
        }
}
