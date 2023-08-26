package com.syboo.shopping.member;

import com.syboo.shopping.member.command.application.dto.SignUpDto;
import com.syboo.shopping.member.command.application.service.MemberService;
import com.syboo.shopping.member.command.domain.model.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * packageName  : com.syboo.shopping.member
 * fileName     : MemberServiceTest
 * author       : 부시연
 * date         : 2023-08-26
 * description  : 회원 서비스 테스트
 * ===========================================================
 * DATE             AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-08-26       부시연             최초 생성
 */
@Transactional
@SpringBootTest
class MemberServiceTest {

    @Autowired
    private MemberService memberService;
    @Test
    @DisplayName("회원 등록 서비스 메소드 테스트")
    void insertTest() {

        // given
        SignUpDto member = SignUpDto.builder()
                .memberId("new_id")
                .build();

        //when
        Member savedMember = memberService.signup(member);
        // then
        assertEquals("new_id", savedMember.getMemberId());

    }
}
