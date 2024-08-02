package org.choongang.member;

import org.choongang.member.constants.Authority;
import org.choongang.member.entities.Authorities;
import org.choongang.member.entities.Member;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MemberUtil { // Member 편의 기능 추가 -> SecurityContextHolder 사용

    public boolean isLogin() { // 로그인 여부 체크
        return getMember() != null;
    }

    public boolean isAdmin() { // 관리자 여부 체크 (다중 권한 체크)
        if (isLogin()) {
            Member member = getMember();
            List<Authorities> authorities = member.getAuthorities(); // 위의 member 연결
            return authorities.stream().anyMatch(s -> s.getAuthority() == Authority.ADMIN); // 값 중에서 1개라도 매칭되면 됨!
        }

        return false;
    }

    public Member getMember() { // 의존성 주입으로 쉽게 사용 가능 -> 2차 가공 | MemberInfo X-> Member 사용
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated() && authentication.getPrincipal() instanceof MemberInfo) { // 구현 객체 타입도 확인 | null 이 아닌 경우 추가
            MemberInfo memberInfo = (MemberInfo) authentication.getPrincipal(); // (MemberInfo) : 형변환

            return memberInfo.getMember();
        }
        return null;
    }
}