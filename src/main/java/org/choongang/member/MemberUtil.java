package org.choongang.member;

import org.choongang.member.entities.Member;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class MemberUtil { // Member 편의 기능 추가 -> SecurityContextHolder 사용

    public boolean isLogin() { // 로그인 여부

    }

    public Member getMember() { // 의존성 주입으로 쉽게 사용 가능 -> 2차 가공 | MemberInfo X-> Member 사용
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.isAuthenticated() && authentication.getPrincipal() instanceof MemberInfo) { // 구현 객체 타입도 확인

        }

        return null;
    }
}