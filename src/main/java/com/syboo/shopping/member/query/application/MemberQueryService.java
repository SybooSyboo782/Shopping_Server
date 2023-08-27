package com.syboo.shopping.member.query.application;

import com.syboo.shopping.member.exception.NoMemberException;
import com.syboo.shopping.member.query.data.MemberData;
import com.syboo.shopping.member.query.data.MemberDataDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * packageName  : com.syboo.shopping.member.query.application
 * fileName     : MemberQueryService
 * author       : 부시연
 * date         : 2023-08-27
 * description  :
 * ===========================================================
 * DATE             AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-08-27       부시연             최초 생성
 */
@Service
public class MemberQueryService {

    private static final Logger log = LoggerFactory.getLogger(MemberQueryService.class);
    MemberDataDao memberDataDao;

    /** 회원 아이디로 회원 검색 */
    public MemberData getMemberData(String memberId) {

        log.info("[MemberQueryService] getMemberData Start ================");
        log.info("[MemberQueryService] memberId : {}", memberId);

        MemberData memberData = memberDataDao.findByMemberId(memberId);
        if (memberData == null) {
            throw new NoMemberException();
        }

        return memberData;
    }
}
