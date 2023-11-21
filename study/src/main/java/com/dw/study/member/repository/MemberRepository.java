package com.dw.study.member.repository;

import com.dw.study.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member,Long> {
    Optional<Member> findByMemberName(String memberName);
    boolean existsByMEmberName(String memberName);
}