package org.choongang.member.repositories;

import org.choongang.member.entities.Member;
import org.choongang.member.entities.QMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface MemberRepository extends JpaRepository<Member, Long>, QuerydslPredicateExecutor {
    default boolean exists(String email) { // 메서드 오버로드
        QMember member = QMember.member;

        return exists(member.email.eq(email));
    }
}