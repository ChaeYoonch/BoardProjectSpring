package org.choongang.member;

import lombok.Builder;
import lombok.Data;
import org.choongang.member.entities.Member;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Data
@Builder
public class MemberInfo implements UserDetails {
    /* 구현 객체 */
    private String email;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;
    private Member member;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonLocked() { // 계정의 잠금 여부
        return true;
    }

    @Override
    public boolean isAccountNonExpired() { // 계정의 만료 여부
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() { // 비밀 번호의 만료 여부
        return true;
    }

    @Override
    public boolean isEnabled() { // 회원 탈퇴 여부 = 회원 활성화 여부
        return true;
    }
}