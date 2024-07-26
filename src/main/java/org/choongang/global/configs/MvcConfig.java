package org.choongang.global.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableJpaAuditing // 세팅 기초 설정에 필요
public class MvcConfig implements WebMvcConfigurer { // MVC 기본 설정

}