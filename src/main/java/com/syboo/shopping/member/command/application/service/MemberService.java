package com.syboo.shopping.member.command.application.service;

import com.syboo.shopping.member.command.application.dto.SignUpDto;
import com.syboo.shopping.member.command.domain.model.Member;
import com.syboo.shopping.member.command.domain.repository.MemberRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * packageName  : com.syboo.shopping.member.command.application.service
 * fileName     : MemberService
 * author       : 부시연
 * date         : 2023-08-26
 * description  : 회원 서비스
 * ===========================================================
 * DATE             AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-08-26       부시연             최초 생성
 */
@Service
public class MemberService {
    private final MemberRepository memberRepository;
    private static final Logger log = LoggerFactory.getLogger(MemberService.class);

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /** 회원 가입 */
    @Transactional
    public Member signup(SignUpDto signUpDto) {
        log.info("[AuthService] Signup Start ===================================");
        log.info("[AuthService] signUpDto {}", signUpDto);

        Member member = new Member(
                signUpDto.getMemberId()
        );

        memberRepository.save(member);

        log.info("[AuthService] Signup End ==============================");

        return member;
    }
}
