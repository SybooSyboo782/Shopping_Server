package com.syboo.shopping.member.query.data;

import org.springframework.data.repository.Repository;

/**
 * packageName  : com.syboo.shopping.member.query.data
 * fileName     : MemberDataDao
 * author       : 부시연
 * date         : 2023-08-27
 * description  :
 * ===========================================================
 * DATE             AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-08-27       부시연             최초 생성
 */
public interface MemberDataDao extends Repository<MemberData, MemberData> {

    MemberData findByMemberId(String memberId);
}
