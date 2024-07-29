package org.choongang.member.controllers;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {

    @GetMapping("/join") // url 주소
    public String join() { // 회원가입
        return "front/member/join";
    }

    @PostMapping("/join")
    public String joinPs(@Valid RequestJoin form) { // 회원가입 프로세스 | @Valid = 검증 | form 형태로 넘김 | 만들어지는 기준 = 앞의 RequestJoin 즉, 클래스명
        return "redirect:/member/login";
    }

    @GetMapping("/login")
    public String login() { // 로그인
        return "front/member/login";
    }
}