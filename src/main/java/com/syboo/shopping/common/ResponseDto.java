package com.syboo.shopping.common;

import lombok.Getter;
import lombok.Setter;
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
 */
@Getter
@Setter
public class ResponseDto {

    private int status;
    private String message;
    private Object data;

    public ResponseDto(HttpStatus status, String message, Object data){
        this.status = status.value();
        this.message = message;
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
