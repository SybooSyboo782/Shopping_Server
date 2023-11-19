package com.syboo.shopping.common;

/**
 * <pre>
 * PackageName : com.syboo.shopping.common
 * FileName : SybooRuntimeException
 * Description:
 * ================================================================
 * DATE              AUTHOR        NOTE
 * ----------------------------------------------------------------
 * 2023-11-19        부시연        최초 생성
 * </pre>
 *
 * @author 부시연(최초 작성자)
 * @version 1(클래스 버전)
 * @see (참고할 class 또는 외부 url)
 */
public class SybooRuntimeException extends RuntimeException{

    public SybooRuntimeException() {
        super();
    }

    public SybooRuntimeException(String msg) {
        super(msg);
    }

    public SybooRuntimeException(Throwable e) {
        super(e);
    }
}
