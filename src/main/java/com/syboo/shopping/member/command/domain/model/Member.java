package com.syboo.shopping.member.command.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.sql.Timestamp;

/**
 * packageName  : com.syboo.shopping.member.command.domain.repository
 * fileName     : Member
 * author       : 부시연
 * date         : 2023-08-20
 * description  : 회원 도메인
 * ===========================================================
 * DATE             AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-08-20       부시연             최초 생성
 * 2023-08-26       부시연             회원 아이디 추가
 */
@Builder
@Getter
@Setter
@Entity
@Table(name = "t_member")
@AllArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "member_no", nullable = false, updatable = false)
    @JdbcTypeCode(SqlTypes.BIGINT)
    private Long memberNo;

    @NotBlank
    @NotEmpty
    @Column(name = "member_id", nullable = false, unique = true)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String memberId;


    @NotBlank
    @NotEmpty
    @Column(name = "password", nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String password;

    @Column(name = "member_create_time")
    private Timestamp createTime;

    @Column(name = "member_upload_time")
    private Timestamp uploadTime;

    protected Member() {}
    public Member(String memberId) {
        this.memberId = memberId;
    }

    public Member(String memberId, String password) {
        this.memberId = memberId;
        this.password = password;
        this.createTime = new Timestamp(System.currentTimeMillis());
        this.uploadTime = new Timestamp(System.currentTimeMillis());
    }
}