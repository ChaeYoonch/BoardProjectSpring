package org.choongang.global.configs;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.choongang.member.services.LoginFailureHandler;
import org.choongang.member.services.LoginSuccessHandler;
import org.choongang.member.services.MemberAuthenticationEntryPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.io.IOException;

@Configuration
@EnableWebSecurity // Web 의 필수 보안 절차
@EnableMethodSecurity
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

        /* 인가 (접근 통제) 설정 S */
        http.authorizeHttpRequests(c -> { // url 로 나눠서 접근
            /* c.requestMatchers("/member/**").anonymous()
             .requestMatchers("/admin/**").hasAnyAuthority("ADMIN").anyRequest().authenticated(); // 회원 전용 */
            c.requestMatchers("/mypage/**").authenticated() // mypage 포함 하위 경로 전체 | authenticated() : 회원인 경우
             .requestMatchers("/admin/**").hasAnyAuthority("ADMIN") // admin 포함 하위 경로 전체 | hasAllAuthority() : 여러 개 중 1개 | hasAuthority() : 1개만
                    .anyRequest().permitAll(); // anonymous : 미로그인 사용자인 경우 | 비회원 전체 -> 페이지 1개
        });

        http.exceptionHandling(c -> {
            c.authenticationEntryPoint(new MemberAuthenticationEntryPoint())
                    .accessDeniedHandler((req, res, e) -> {
                        res.sendError(HttpStatus.UNAUTHORIZED.value()); // 응답 코드 401
                    });
                    /*.accessDeniedHandler(new AccessDeniedHandler() {
                        @Override
                        public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {

                        }
                    }); */
        });
        /* 인가 (접근 통제) 설정 E */

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}