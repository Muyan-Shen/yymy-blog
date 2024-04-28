package com.cystrix.blog.util;

import com.cystrix.blog.enums.RedisEnum;
import com.cystrix.blog.exception.EmailOpsException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeUtility;
import java.util.Random;

/**
 * @author: chenyue7@foxmail.com
 * @date: 18/7/2023
 * @description:
 */
@Component
public class EmailUtils {

    @Value("${spring.mail.username}")
    private String from;

    @Resource
    private JavaMailSender javaMailSender;
    @Resource
    private RedisUtils redisUtils;
    // 过期时间(秒)
    private final static long EMAIL_CODE_EXPIRE_TIME = 60 * 10;


    public void sendVerificationCodeToEmail(String emailReceiver) {
        SimpleMailMessage message = new SimpleMailMessage();
        // 发件人
        message.setFrom(from);
        String verificationCode = generateEmailVerificationCode(6);
        message.setSubject("YymyBlog后台登录验证码");
        message.setText("尊敬的用户您好!\n\n欢迎使用YymyBlog系统。\n\n您的登录验证码为：" + verificationCode +
                ",有效期十分钟，请不要把验证码信息泄露给其他人，如非本人请勿操作。");
        message.setTo(emailReceiver);
        try {
            message.setFrom(new InternetAddress(MimeUtility.encodeText("YymyBlog系统服务") + "<504142151@qq.com>").toString());
            javaMailSender.send(message);
            String redisKey = RedisEnum.VERIFICATION_LOGIN_PREFIX_.name() + '_' + emailReceiver;
            redisUtils.setValue(redisKey, verificationCode);
            redisUtils.setExpireTime(redisKey, EMAIL_CODE_EXPIRE_TIME);
        }catch (Exception e) {
            throw new EmailOpsException(e.getMessage());
        }
    }

    public String generateEmailVerificationCode(int length) {
        Random random = new Random(System.currentTimeMillis());
        StringBuilder verificationCode = new StringBuilder();
        String c = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < length; i++) {
            // 从字符集中随机选择一个字符，并将其添加到验证码中
            int index = random.nextInt(c.length());
            char randomChar = c.charAt(index);
            verificationCode.append(randomChar);
        }
        return verificationCode.toString();
    }
}
