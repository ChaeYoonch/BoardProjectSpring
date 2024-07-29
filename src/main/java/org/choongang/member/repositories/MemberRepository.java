package org.choongang.member.repositories;

import org.choongang.member.entities.Member;
import org.choongang.member.entities.QMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long>, QuerydslPredicateExecutor {

    Optional<Member> findByEmail(String email);

    default boolean exists(String email) { // 메서드 오버로드
        QMember member = QMember.member;

        return exists(member.email.eq(email));
    }
}