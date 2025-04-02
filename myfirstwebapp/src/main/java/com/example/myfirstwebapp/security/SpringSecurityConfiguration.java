package com.example.myfirstwebapp.security;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails userDetails1 = createNewUser("홍길동", "test1");
        UserDetails userDetails2 = createNewUser("홍동", "test2");
        return new InMemoryUserDetailsManager(userDetails1, userDetails2);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
            auth -> auth.anyRequest().authenticated());
        http.formLogin(withDefaults());
        // http.csrf().disable(); Deprecated
        http.csrf(csrf -> csrf.disable());
        // http.headers().frameOptions().disable(); Deprecated
        http.headers(headers -> headers.frameOptions(frameOptions -> frameOptions.disable()));
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    private UserDetails createNewUser(String username, String password) {
        UserDetails userDetails = User.builder()
            .passwordEncoder(input -> passwordEncoder().encode(input)) // 비밀번호 암호화
            .username(username)
            .password(password) // 원본 비밀번호 - 암호화됨
            .roles("USER", "ADMIN")
            .build();
        return userDetails;
    }
}
