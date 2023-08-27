package com.syboo.shopping.member.query;

import com.syboo.shopping.member.command.application.dto.SignUpDto;
import com.syboo.shopping.member.command.application.service.MemberService;
import com.syboo.shopping.member.command.domain.model.Member;
import com.syboo.shopping.member.query.data.MemberDataDao;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * packageName  : com.syboo.shopping.member
 * fileName     : MemberQueryServiceTest
 * author       : 부시연
 * date         : 2023-08-27
 * description  :
 * ===========================================================
 * DATE             AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-08-27       부시연             최초 생성
 */
@Transactional
@SpringBootTest
class MemberQueryServiceTest {

    @Autowired
    private MemberDataDao memberDataDao;
    @Autowired
    private MemberService memberService;


    @Test
    @DisplayName("회원 아이디 검색 메소드 테스트")
    void findByMemberId() {
        // given
        SignUpDto member = SignUpDto.builder()
                .memberId("test_id")
                .build();
        Member savedMember = memberService.signup(member);

        // when
        String memberId = memberDataDao.findByMemberId("test_id").findMemberId();

        // then
        assertThat(memberId).isEqualTo(savedMember.getMemberId());

    }

}
