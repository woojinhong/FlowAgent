package com.post.kr.flowagent.core.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        // BCrypt는 비밀번호 해싱을 위한 가장 표준적이고 안전한 방법 중 하나입니다.
        return new BCryptPasswordEncoder();
    }
}