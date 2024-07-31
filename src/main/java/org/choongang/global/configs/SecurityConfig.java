package org.choongang.global.configs;

import org.choongang.member.services.LoginFailureHandler;
import org.choongang.member.services.LoginSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig {

    @Bean // 스프링 관리 객체로 설정
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception { // 반환값 = http | 스프링 시큐리티 주 설정 위치
        /* 로그인, 로그아웃 S */
        http.formLogin(f -> { // 영역 도메인별로 나눠서 설정 O -> 람다 형태 | 로그인
            f.loginPage("/member/login") // 로그인 시 이동할 경로
             .usernameParameter("email")
             .passwordParameter("password")
             .successHandler(new LoginSuccessHandler())
             /*.successForwardUrl("/") // 로그인 성공 시 이동할 경로 | Forward : 버퍼 치환 -> 페이지 이동 X */
             .failureHandler(new LoginFailureHandler());
             /*.failureUrl("/member/login?error=true"); // 로그인 실패 시 이동할 경로 | Url -> 페이지 이동 O */
        });

        http.logout(f -> { // 도메인 특화 방식 | 로그아웃
            f.logoutRequestMatcher(new AntPathRequestMatcher("/member/logout")).logoutSuccessUrl("/member/login");
        });
        /* 로그인, 로그아웃 E */

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}