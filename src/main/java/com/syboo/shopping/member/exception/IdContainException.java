package com.syboo.shopping.member.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * <pre>
 * PackageName : com.syboo.shopping.member.exception
 * FileName : 아이디 포함 시 예외처리
 * Description:
 * ================================================================
 * DATE              AUTHOR        NOTE
 * ----------------------------------------------------------------
 * 2023-09-30        부시연        최초 생성
 * </pre>
 *
 * @author 부시연(최초 작성자)
 * @version 1(클래스 버전)
 */
@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "비밀번호에 아이디가 포함 되었습니다.")
public class IdContainException extends RuntimeException {
    public IdContainException() { super(); }

    public IdContainException(String message) {
        super(message);
    }

    public IdContainException(String message, Throwable cause) {
        super(message, cause);
    }

    public IdContainException(Throwable cause) {
        super(cause);
    }

}