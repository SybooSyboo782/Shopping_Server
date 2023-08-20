package com.syboo.shopping.member;

import com.syboo.shopping.member.command.domain.model.Member;
import com.syboo.shopping.member.command.domain.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * packageName  : com.syboo.shopping.member
 * fileName     : MemberRepositoryTest
 * author       : 부시연
 * date         : 2023-08-20
 * description  :
 * ===========================================================
 * DATE             AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-08-20       부시연             최초 생성
 */
@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    private MemberRepository repository;

    @Test
    void insertTest() {
        for(int i =0; i < 10; i++) {
            Member member = Member.builder()
                    .build();

            repository.save(member);
        }
    }
}
