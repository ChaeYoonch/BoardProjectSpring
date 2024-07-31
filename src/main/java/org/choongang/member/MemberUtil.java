package org.choongang.member;

import org.choongang.member.entities.Member;
import org.springframework.stereotype.Component;

@Component
public class MemberUtil { // Member 편의 기능 추가 -> Security ContextHolder 사용

    public boolean isLogin() { // 로그인 여부

    }

    public Member getMember() { // 의존성 주입으로 쉽게 사용 가능 -> 2차 가공

    }
}