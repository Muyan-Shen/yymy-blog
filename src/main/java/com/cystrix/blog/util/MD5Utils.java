package com.cystrix.blog.util;

import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

import java.util.Base64;

/**
 * @author: chenyue7@foxmail.com
 * @date: 13/7/2023
 * @description:
 */
@Component
public class MD5Utils {

    private final String salt = "a972kjs02jf85nsdla91f,';[3";

    /**
     * 获得md5加密后的base64编码
     * @param password 密码明文
     */
    public String encryption(String password) {
        int iterations = 200;

        for (int i = 0; i < iterations; i++) {
            password = DigestUtils.md5DigestAsHex((password + salt).getBytes());
        }
        return Base64.getEncoder().encodeToString(password.getBytes());
    }

    public static void main(String[] args) {
        MD5Utils md5Utils = new MD5Utils();
        System.out.println(md5Utils.encryption("123456"));
    }
}
