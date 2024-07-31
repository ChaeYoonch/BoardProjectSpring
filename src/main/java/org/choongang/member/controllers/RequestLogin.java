package org.choongang.member.controllers;

import lombok.Data;

@Data
public class RequestLogin { // 로그인 커맨드 객체 추가

    private String email;
    private String password;
}