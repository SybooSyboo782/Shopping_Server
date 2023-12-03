package com.syboo.shopping.common.encrypt;

import com.syboo.shopping.common.SybooRuntimeException;
import org.springframework.stereotype.Service;

import javax.crypto.*;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

/**
 * <pre>
 * PackageName : com.syboo.shopping.common
 * FileName : AesEncryptionService
 * Description:
 * ================================================================
 * DATE              AUTHOR        NOTE
 * ----------------------------------------------------------------
 * 2023-11-19        부시연        최초 생성
 * </pre>
 *
 * @author 부시연(최초 작성자)
 * @version 1(클래스 버전)
 */
@Service
public class AesEncryptionService implements EncryptionInterface {

    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES/GCM/NoPadding";
    private static final int GCM_TAG_LENGTH = 128;

    private static final String aes256SecretKey = "ThisIsASecretKey1234567890123456";

    @Override
    public String aesEncrypt(String plaintext) {
        SecureRandom secureRandom = new SecureRandom();
        byte[] iv = new byte[12]; // GCM 모드에서는 IV(Initialization Vector)의 길이가 12바이트로 고정
        secureRandom.nextBytes(iv);

        SecretKey secretKey = new SecretKeySpec(aes256SecretKey.getBytes(StandardCharsets.UTF_8), ALGORITHM);
        Cipher cipher = null;
        try {
            cipher = Cipher.getInstance(TRANSFORMATION);
            GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(GCM_TAG_LENGTH, iv);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, gcmParameterSpec);
            byte[] ciphertext = cipher.doFinal(plaintext.getBytes(StandardCharsets.UTF_8));
            // IV와 암호문을 합쳐서 Base64로 인코딩
            byte[] ivAndCiphertext = new byte[iv.length + ciphertext.length];
            System.arraycopy(iv, 0, ivAndCiphertext, 0, iv.length);
            System.arraycopy(ciphertext, 0, ivAndCiphertext, iv.length, ciphertext.length);
            return Base64.getEncoder().encodeToString(ivAndCiphertext);
        } catch (NoSuchAlgorithmException | InvalidAlgorithmParameterException | InvalidKeyException |
                 NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException e) {
            throw new SybooRuntimeException(e);
        }
    }

    @Override
    public String aesDecrypt(String encryptedText) {
        byte[] ivAndCiphertext = Base64.getDecoder().decode(encryptedText);

        // IV는 처음 12바이트
        byte[] iv = new byte[12];
        System.arraycopy(ivAndCiphertext, 0, iv, 0, iv.length);

        // 나머지는 암호문
        byte[] ciphertext = new byte[ivAndCiphertext.length - iv.length];
        System.arraycopy(ivAndCiphertext, iv.length, ciphertext, 0, ciphertext.length);

        SecretKey secretKey = new SecretKeySpec(aes256SecretKey.getBytes(StandardCharsets.UTF_8), ALGORITHM);
        Cipher cipher = null;
        try {
            cipher = Cipher.getInstance(TRANSFORMATION);
            GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(GCM_TAG_LENGTH, iv);
            cipher.init(Cipher.DECRYPT_MODE, secretKey, gcmParameterSpec);
            byte[] decryptedText = cipher.doFinal(ciphertext);
            return new String(decryptedText, StandardCharsets.UTF_8);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | BadPaddingException | IllegalBlockSizeException |
                 InvalidAlgorithmParameterException | InvalidKeyException e) {
            throw new SybooRuntimeException(e);
        }


    }
}
