package com.syboo.shopping.common.encrypt;

public interface EncryptionInterface {
    String aesEncrypt(String plaintext);
    String aesDecrypt(String encryptedText);
}
