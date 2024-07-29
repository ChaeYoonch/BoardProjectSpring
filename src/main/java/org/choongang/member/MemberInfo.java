package org.choongang.member;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class MemberInfo implements UserDetails {

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return "";
    }

    @Override
    public String getUsername() {
        return "";
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() { // 계정의 잠금 여부
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() { // 비밀 번호의 만료 여부
        return true;
    }

    @Override
    public boolean isEnabled() { // 회원 탈퇴 여부
        return UserDetails.super.isEnabled();
    }
}