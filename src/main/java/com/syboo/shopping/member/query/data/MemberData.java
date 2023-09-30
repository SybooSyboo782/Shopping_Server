package com.syboo.shopping.member.query.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * packageName  : com.syboo.shopping.member.query.data
 * fileName     : MemberData
 * author       : 부시연
 * date         : 2023-08-27
 * description  :
 * ===========================================================
 * DATE             AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-08-27       부시연             최초 생성
 */
@Entity
@Table(name = "t_member")
@Builder
@AllArgsConstructor
public class MemberData {

    @Id
    @Column(name = "member_no")
    private Long memberNo;

    @Getter
    @Column(name = "member_id")
    private String memberId;

    @Column(name = "password")
    private String password;

    protected MemberData() {}

    public String findMemberId() {
        return memberId;
    }

}
