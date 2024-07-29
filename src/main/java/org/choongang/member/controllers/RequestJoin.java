package org.choongang.member.controllers;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RequestJoin { // 사용자가 작성한 데이터 전달 - 커맨드 객체
    @NotBlank // 필수 항목
    private String email; // 이메일

    @NotBlank
    private String password; // 비밀번호

    @NotBlank
    private String confirmPassword; // 비밀번호 확인

    @NotBlank
    private String userName; // 회원명
    private String mobile; // 전화번호
    private boolean agree; // 약관 동의
}