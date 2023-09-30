package com.syboo.shopping.member.command.application.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * packageName  : com.syboo.shopping.member.command.application.dto
 * fileName     : SignUpDto
 * author       : 부시연
 * date         : 2023-08-26
 * description  : 회원 가입용 전송 객체
 * ===========================================================
 * DATE             AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-08-26       부시연             최초 생성
 */
@Getter
@Builder
@AllArgsConstructor
public class SignUpDto {
    protected SignUpDto() {}

    @NotBlank
    private String memberId;

    @NotBlank
    private String password;

}
