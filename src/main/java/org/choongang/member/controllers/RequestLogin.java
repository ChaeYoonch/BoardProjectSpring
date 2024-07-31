package org.choongang.member.controllers;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RequestLogin { // 로그인 커맨드 객체 추가
    @NotBlank
    private String email;

    @NotBlank
    private String password;

    private boolean success = true;

    private String code; // 에러 코드 -> 글로벌 에러로 출력될 수 있도록 만들 예정

    private String defaultMessage;
}