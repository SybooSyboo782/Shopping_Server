package com.syboo.shopping.member.command;

import com.syboo.shopping.member.command.application.dto.IdRequestDto;
import com.syboo.shopping.member.command.application.dto.SignUpDto;
import com.syboo.shopping.member.command.application.service.MemberService;
import com.syboo.shopping.member.command.domain.model.Member;
import com.syboo.shopping.member.command.domain.repository.MemberRepository;
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
    @Autowired
    private MemberRepository memberRepository;
    @Test
    @DisplayName("회원 등록 서비스 메소드 테스트")
    void insertTest() {

        // given
        SignUpDto member = SignUpDto.builder()
                .memberId("new_id")
                .password("test1234!")
                .build();

        //when
        Member savedMember = memberService.signup(member);
        // then
        assertEquals("new_id", savedMember.getMemberId());

    }

    @Test
    @DisplayName("아이디 중복검사 메소드 테스트")
    public void IdCheck() throws Exception{

        // 중복되지 않는 아이디를 사용해서 테스트
        IdRequestDto idRequestDto = IdRequestDto.builder()
                .memberId("newMemberId")
                .build();

        String isUnique = memberService.idCheck(idRequestDto);
        assertEquals("중복된 아이디가 없습니다", isUnique);

        // 위에서 사용한 아이디 값을 이용하여 회원 생성 후 중복 되는지 테스트
        Member existingMember = Member.builder()
                .memberId("newMemberId")
                .password("existingMemberPw1@")
                .build();
        memberRepository.save(existingMember);

        String isNotUnique = memberService.idCheck(idRequestDto);
        assertEquals("중복된 아이디가 존재합니다", isNotUnique);
    }
}
