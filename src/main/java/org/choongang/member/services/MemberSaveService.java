package org.choongang.member.services;

import lombok.RequiredArgsConstructor;
import org.choongang.member.constants.Authority;
import org.choongang.member.controllers.RequestJoin;
import org.choongang.member.entities.Authorities;
import org.choongang.member.entities.Member;
import org.choongang.member.repositories.AuthoritiesRepository;
import org.choongang.member.repositories.MemberRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberSaveService {
    private final MemberRepository memberRepository;
    private final AuthoritiesRepository authoritiesRepository;
    private final PasswordEncoder passwordEncoder;

    /**
     * 회원 가입 처리
     * @param form
     */
    public void save(RequestJoin form) {
        Member member = new ModelMapper().map(form, Member.class); // ModelMapper : setter & getter 반복 -> 데이터 치환
        String hash = passwordEncoder.encode(form.getPassword()); // BCrypt 형태로 해시화
        member.setPassword(hash); // 위의 hash 값 연동

        save(member, List.of(Authority.USER)); // 사용자 권한
    }

    public void save(Member member, List<Authority> authorities) { // 매개 변수 2개

        memberRepository.saveAndFlush(member);

        if (authorities != null) { // 객체가 아닌 경우에만 비움
            List<Authorities> items = authoritiesRepository.findByMember(member); // 값을 가져온 다음 변경
            authoritiesRepository.deleteAll(items); // items 가져온 다음 비움 | 기존의 것 비움
            authoritiesRepository.flush();

            items = authorities.stream().map(a -> Authorities.builder()
                                                             .member(member)
                                                             .authority(a)
                                                             .build()).toList(); // 새롭게 채움 (갱신)
        }
    }
}