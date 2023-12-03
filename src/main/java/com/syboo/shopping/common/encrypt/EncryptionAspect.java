package com.syboo.shopping.common.encrypt;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <pre>
 * PackageName : com.syboo.shopping.common.aspect
 * FileName : EncryptionAspect
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
@Aspect
@Component
public class EncryptionAspect {
    private static final Logger log = LoggerFactory.getLogger(EncryptionAspect.class);


    @Autowired
    private EncryptionInterface encryptionInterface;

    @Before("execution(* com.syboo.shopping.common.encrypt.EncryptionInterface.aesEncrypt(..)) && args(data)")
    public void beforeEncrypt(String data) {
        // 암호화 메서드 호출 전에 수행할 로직
        log.info("Performing pre-encryption tasks");
    }

    @Before("execution(* com.syboo.shopping.common.encrypt.EncryptionInterface.aesDecrypt(..)) && args(encryptedData)")
    public void beforeDecrypt(String encryptedData) {
        // 복호화 메서드 호출 전에 수행할 로직
        log.info("Performing pre-decryption tasks");
    }
}
