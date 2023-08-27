package com.syboo.shopping.member.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * packageName  : com.syboo.shopping.member.exception
 * fileName     : NoMemberException
 * author       : 부시연
 * date         : 2023-08-27
 * description  : 없는 회원을 조회할 때 발생 하는 예외 처리
 * ===========================================================
 * DATE             AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-08-27       부시연             최초 생성
 */
@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "해당 회원은 존재 하지 않습니다")
public class NoMemberException extends RuntimeException {
    public NoMemberException() {
        super();
    }

    public NoMemberException(String message) {
        super(message);
    }

    public NoMemberException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoMemberException(Throwable cause) {
        super(cause);
    }

}
