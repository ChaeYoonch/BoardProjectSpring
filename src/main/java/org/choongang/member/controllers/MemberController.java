package org.choongang.member.controllers;

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
    public String joinPs() { // 회원가입 프로세스
        return "redirect:/member/login";
    }
}