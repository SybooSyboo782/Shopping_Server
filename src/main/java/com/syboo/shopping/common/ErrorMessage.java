package com.syboo.shopping.common;

import lombok.Value;

/**
 * <pre>
 * PackageName : com.syboo.shopping.common
 * FileName : ErrorMessage
 * Description:
 * ================================================================
 * DATE              AUTHOR        NOTE
 * ----------------------------------------------------------------
 * 2023-10-03        부시연        최초 생성
 * </pre>
 *
 * @author 부시연(최초 작성자)
 * @version 1(클래스 버전)
 * @see (참고할 class 또는 외부 url)
 */
@Value
public class ErrorMessage {

    private String message;

    public static ErrorMessage from(final String message) {
        return new ErrorMessage(message);
    }
}