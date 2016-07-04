package easy.media.marketing.os.framework.commons.utils;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

/**
 * 编码工具类
 *
 * Created by jeleo on 16-7-4.
 */
public class Encoding {

    private final static String MD5_SALT = "EMM";

    private final static Md5PasswordEncoder md5PasswordEncoder;

    static {
        md5PasswordEncoder = new Md5PasswordEncoder();
    }

    public static String MD5(String password) {
        return md5PasswordEncoder.encodePassword(password, MD5_SALT);
    }

}
