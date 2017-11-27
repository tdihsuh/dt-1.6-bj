package com.cycredit.base.utils;

import java.io.UnsupportedEncodingException;

/**
 * Created by qiyubin on 2017/7/5 0005.
 */
public class SecurityTools {

    public static final String HASH_ALGORITHM = "SHA-1";
    public static final int HASH_INTERATIONS = 1024;
    public static final int SALT_SIZE = 8;

    public static final String CHARSET_NAME = "utf-8";

    /**
     * 生成安全的密码，生成随机的16位salt并经过1024次 sha-1 hash
     */
    public static String entryptPassword(String plainPassword) {
        String plain = Encodes.unescapeHtml(plainPassword);
        byte[] salt = Digests.generateSalt(SALT_SIZE);
        byte[] hashPassword = new byte[0];
        try {
            hashPassword = Digests.sha1(plain.getBytes(CHARSET_NAME), salt, HASH_INTERATIONS);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return Encodes.encodeHex(salt) + Encodes.encodeHex(hashPassword);
    }


}
