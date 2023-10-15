package com.syboo.shopping.member.command.application.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * <pre>
 * PackageName : com.syboo.shopping.member.command.application.dto
 * FileName : IdRequestDto
 * Description:
 * ================================================================
 * DATE              AUTHOR        NOTE
 * ----------------------------------------------------------------
 * 2023-10-10        부시연        최초 생성
 * </pre>
 *
 * @author 부시연(최초 작성자)
 * @version 1(클래스 버전)
 */
@Getter
@Builder
@AllArgsConstructor
public class IdRequestDto {

    protected IdRequestDto () {}

    @NotEmpty(message = "아이디가 없습니다.")
    @Pattern(regexp =  "^[_.a-zA-Z0-9]{1,20}$", message = "아이디명은 특수문자(-.)를 포함하여 20자 이내로 작성 가능합니다")
    private String memberId;
}
