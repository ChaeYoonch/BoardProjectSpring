package org.choongang.member.services;

import lombok.RequiredArgsConstructor;
import org.choongang.member.MemberInfo;
import org.choongang.member.constants.Authority;
import org.choongang.member.entities.Authorities;
import org.choongang.member.entities.Member;
import org.choongang.member.repositories.MemberRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class MemberInfoService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                                         // 여기 username 연동       이 예외 UsernameNotFoundException 연동
        Member member = memberRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException(username));

        List<Authorities> tmp = Objects.requireNonNullElse(member.getAuthorities(), // 위의 member 연결
                                List.of(Authorities.builder().member(member).authority(Authority.USER).build()));

        List<SimpleGrantedAuthority> authorities = tmp.stream().map(a -> new SimpleGrantedAuthority(a.getAuthority().name())).toList(); // 위의 tmp 연동 | SimpleGrantedAuthority -> 문자열이 들어가야 하므로 a.getAuthority().name() 형태!

        return MemberInfo.builder()
                         .email(member.getEmail()) // email
                         .password(member.getPassword()) // password
                         .member(member) // member 기타 정보
                         .authorities(authorities)
                         .build();
    }
}