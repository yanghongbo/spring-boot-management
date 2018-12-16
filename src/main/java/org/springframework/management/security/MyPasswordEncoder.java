package org.springframework.management.security;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 自定义密码的编码器，会用于登录验证时对输入密码的加密和校验
 */
public class MyPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence rawPassword) {
        return rawPassword.toString();
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return encodedPassword.equals(rawPassword.toString());
    }
}
