package org.choongang.member.controllers;

import lombok.Data;

@Data
public class RequestJoin {
    // 사용자가 작성한 데이터 전달 - 커맨드 객체
    private String email; // 이메일
    private String password; // 비밀번호
    private String confirmPassword; // 비밀번호 확인
    private String userName; // 회원명
    private String mobile; // 전화번호
}