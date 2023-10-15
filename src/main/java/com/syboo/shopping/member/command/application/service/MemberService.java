package com.syboo.shopping.member.command.application.service;

import com.syboo.shopping.member.command.application.dto.IdRequestDto;
import com.syboo.shopping.member.command.application.dto.SignUpDto;
import com.syboo.shopping.member.command.domain.model.Member;
import com.syboo.shopping.member.command.domain.repository.MemberRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    private final PasswordEncoder passwordEncoder;
    private static final Logger log = LoggerFactory.getLogger(MemberService.class);

    public MemberService(MemberRepository memberRepository, PasswordEncoder passwordEncoder) {
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /** 회원 가입 */
    @Transactional
    public Member signup(SignUpDto signUpDto) {
        log.info("[MemberService] Signup Start ===================================");
        log.info("[MemberService] signUpDto {}", signUpDto);

        Member member = new Member(
                signUpDto.getMemberId(),
                passwordEncoder.encode(signUpDto.getPassword())
        );

        memberRepository.save(member);

        log.info("[MemberService] Signup End ==============================");

        return member;
    }

    /** 아이디 중복검사 */
    public String idCheck(IdRequestDto idRRequestDto) {

        log.info("[AuthQueryService] idCheck Start =================");
        log.info("[AuthQueryService] newMemberId {}", idRRequestDto.getMemberId());

        String idCheck = "";

        if(!memberRepository.existsByMemberId(idRRequestDto.getMemberId())) {
            idCheck = "중복된 아이디가 없습니다";
        } else {
            idCheck = "중복된 아이디가 존재합니다";
        }

        return idCheck;

    }
}
