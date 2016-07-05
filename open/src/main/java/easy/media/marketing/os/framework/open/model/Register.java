package easy.media.marketing.os.framework.open.model;

import easy.media.marketing.os.framework.open.error.OpenErrorString;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 表单提交的注册信息封装
 *
 * Created by jeleo on 16-7-4.
 */
public class Register {

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

    @NotEmpty(message = OpenErrorString.e10004)
    private String username;

    @NotEmpty(message = OpenErrorString.e10007)
    private String password;

    @NotEmpty(message = OpenErrorString.e10002)
    private String email;

    @NotEmpty(message = OpenErrorString.e20001)
    private String passwordConfirmed;

    @NotEmpty(message = OpenErrorString.e10000)
    private String captcha;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordConfirmed() {
        return passwordConfirmed;
    }

    public void setPasswordConfirmed(String passwordConfirmed) {
        this.passwordConfirmed = passwordConfirmed;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }
}
