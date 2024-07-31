package org.choongang.global.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean // 스프링 관리 객체로 설정
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception { // 반환값 = http | 스프링 시큐리티 주 설정 위치
        /* 로그인, 로그아웃 S */
        http.formLogin(f -> { // 영역 도메인별로 나눠서 설정 O -> 람다 형태
            f.usernameParameter("email")
             .passwordParameter("password")
             .successForwardUrl("/") // 성공 시 이동할 경로
             .failureForwardUrl("/member/login?error=true"); // 실패 시 이동할 경로
        });
        /* 로그인, 로그아웃 E */

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}