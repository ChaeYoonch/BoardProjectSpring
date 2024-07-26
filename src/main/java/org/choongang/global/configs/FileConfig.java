package org.choongang.global.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class FileConfig implements WebMvcConfigurer {

    @Value("${file.upload.path") // 설정 내용에서 값을 가져와 주입
    private String path;

    @Value("${file.upload.url") // 설정 내용에서 값을 가져와 주입
    private String url;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

    }
}