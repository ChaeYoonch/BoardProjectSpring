package org.choongang.member.controllers;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {

    @GetMapping("/join") // url 주소
    public String join(@ModelAttribute RequestJoin form) { // 회원가입
        return "front/member/join";
    }

    @PostMapping("/join")
    public String joinPs(@Valid RequestJoin form, Errors errors) { // 회원가입 프로세스 | @Valid = 검증 | form 형태로 넘김 갑싱 없거나 검증 실패시 Errors 로 이동| 만들어지는 기준 = 앞의 RequestJoin 즉, 클래스명

        if (errors.hasErrors()) { // error 가 있으면
            return "front/member/join"; // 여기로 이동
        }

        return "redirect:/member/login";
    }

    @GetMapping("/login")
    public String login() { // 로그인
        return "front/member/login";
    }
}