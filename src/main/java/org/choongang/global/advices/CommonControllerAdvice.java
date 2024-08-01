package org.choongang.global.advices;

import lombok.RequiredArgsConstructor;
import org.choongang.member.MemberUtil;
import org.choongang.member.entities.Member;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@RequiredArgsConstructor
@ControllerAdvice("org.choongang")
public class CommonControllerAdvice { // 모든 컨트롤러 공통 값 유지 (컨트롤러 실행 전에)

    private final MemberUtil memberUtil;

    @ModelAttribute("loggedMember") // 로그인한 회원 정보
    public Member loggedMember() {
        return memberUtil.getMember();
    }

    @ModelAttribute("isLogin")
    public boolean isLogin() { // 로그인 여부
        return memberUtil.isLogin();
    }

    @ModelAttribute("isAdmin")
    public boolean isAdmin() { // 관리자 여부
        return memberUtil.isAdmin();
    }
}