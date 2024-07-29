package org.choongang.member.repositories;

import org.choongang.member.entities.Authorities;
import org.choongang.member.entities.AuthoritiesId;
import org.choongang.member.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface AuthoritiesRepository extends JpaRepository<Authorities, AuthoritiesId>, QuerydslPredicateExecutor<Authorities> {

    List<Authorities> findByMember(Member member); // 회원 정보 -> 조회 | 비우고 다시 추가
}