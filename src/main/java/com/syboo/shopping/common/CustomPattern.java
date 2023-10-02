package com.syboo.shopping.common;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <pre>
 * PackageName : com.syboo.shopping.common
 * FileName : CustomPattern
 * Description: 사용자 입력 패턴
 * ================================================================
 * DATE              AUTHOR        NOTE
 * ----------------------------------------------------------------
 * 2023-09-30        부시연        최초 생성
 * </pre>
 *
 * @author 부시연(최초 작성자)
 * @version 1(클래스 버전)
 */
@Component
public class CustomPattern {

    /** 아이디 패턴 값 분석 */
    public boolean idPattern(String memberId) {

        Pattern pattern = Pattern.compile("^[_.a-zA-Z0-9]{1,15}$");

        Matcher matcher = pattern.matcher(memberId);

        return matcher.matches();
    }

    /** 비밀번호 패턴 값 분석 */
    public boolean passwordPattern(String password) {

        Pattern pattern = Pattern.compile("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@!%*#?&])[A-Za-z\\d$@!%*#?&]{8,20}$");

        Matcher matcher = pattern.matcher(password);

        return matcher.matches();
    }

    /** 아이디 포함 여부 */
    public boolean idContain(String memberId, String password) {
        return password.contains(memberId);
    }

}