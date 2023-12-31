package com.syboo.shopping.member.command.domain.repository;

import com.syboo.shopping.member.command.domain.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * packageName  : com.syboo.shopping.member.command.domain.repository
 * fileName     : MemberRepository
 * author       : 부시연
 * date         : 2023-08-20
 * description  : 회원 레포지토리
 * ===========================================================
 * DATE             AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-08-20       부시연             최초 생성
 */
@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    boolean existsByMemberId(String newMemberId);
}
