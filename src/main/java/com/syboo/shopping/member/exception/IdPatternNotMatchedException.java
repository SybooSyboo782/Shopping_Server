package com.syboo.shopping.member.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * <pre>
 * PackageName : com.syboo.shopping.member.exception
 * FileName : 아이디 패턴 불일치 예외처리
 * Description:
 * ================================================================
 * DATE              AUTHOR        NOTE
 * ----------------------------------------------------------------
 * 2023-09-30        부시연        최초 생성
 * </pre>
 *
 * @author 부시연(최초 작성자)
 * @version 1(클래스 버전)
 * @see (참고할 class 또는 외부 url)
 */
@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "잘못된 아이디 요청입니다.")
public class IdPatternNotMatchedException extends RuntimeException {
    public IdPatternNotMatchedException() { super(); }

    public IdPatternNotMatchedException(String message) {
        super(message);
    }

    public IdPatternNotMatchedException(String message, Throwable cause) {
        super(message, cause);
    }

    public IdPatternNotMatchedException(Throwable cause) {
        super(cause);
    }

}