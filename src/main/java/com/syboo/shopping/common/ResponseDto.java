package com.syboo.shopping.common;

import org.springframework.http.HttpStatus;

/**
 * <pre>
 * PackageName : com.syboo.shopping.common
 * FileName : ResponseDto
 * Description: 공용 응답 전송 객체
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
public class ResponseDto {

    private int status;
    private String message;
    private Object data;

    public ResponseDto(HttpStatus status, String message, Object data){
        this.status = status.value();
        this.message = message;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseDto{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
