package org.choongang.member.services;

import lombok.RequiredArgsConstructor;
import org.choongang.member.repositories.AuthoritiesRepository;
import org.choongang.member.repositories.MemberRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberSaveService {
    private final MemberRepository memberRepository;
    private final AuthoritiesRepository authoritiesRepository;
}