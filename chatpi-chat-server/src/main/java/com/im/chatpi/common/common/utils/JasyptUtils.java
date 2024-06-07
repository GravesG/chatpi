package com.im.chatpi.common.common.utils;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.EnvironmentStringPBEConfig;

public class JasyptUtils {

    private static final String ENCRYPT_KEY = "XX";
    private static final String MYSQL_PWD = "XX";
    private static final String REDIS_PWD = "XX";

    public static void main(String[] args) {
        System.out.println(encrypt(MYSQL_PWD));
        System.out.println(encrypt(REDIS_PWD));
    }

    /**
     * 加密
     *
     * @param plaintext 明文
     * @return
     */
    public static String encrypt(String plaintext) {
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        EnvironmentStringPBEConfig config = new EnvironmentStringPBEConfig();
        // 指定算法
        config.setAlgorithm("PBEWithMD5AndDES");
        // 指定秘钥，和yml配置文件中保持一致
        config.setPassword(ENCRYPT_KEY);
        encryptor.setConfig(config);
        // 生成加密数据
        return encryptor.encrypt(plaintext);
    }

    /**
     * 解密
     *
     * @param data 加密后数据
     * @return
     */
    public static String decrypt(String data) {
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        EnvironmentStringPBEConfig config = new EnvironmentStringPBEConfig();
        config.setAlgorithm("PBEWithMD5AndDES");
        config.setPassword(ENCRYPT_KEY);
        encryptor.setConfig(config);
        // 解密数据
        return encryptor.decrypt(data);
    }

}
