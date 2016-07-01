package easy.media.marketing.os.framework.open.security;

import easy.media.marketing.os.framework.commons.utils.Captcha;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class UsernamePasswordCaptchaAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    public static final String SECURITY_FORM_CAPTCHA_KEY = "captcha";

    public UsernamePasswordCaptchaAuthenticationFilter() {
        super.setFilterProcessesUrl(Securities.loginFilterProcessesUrl);
        super.setAuthenticationFailureHandler(failureHandler());
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        String captchaInput = this.obtainCaptcha(request);
        if (StringUtils.isEmpty(captchaInput)) {
            throw new AuthenticationServiceException("验证码不允许为空");
        }
        String captchaInSession = this.getCaptchaFromSession(request);
        if (!StringUtils.equalsIgnoreCase(captchaInSession, captchaInput)) {
            throw new AuthenticationServiceException("验证码错误");
        }
        return super.attemptAuthentication(request, response);
    }

    @Bean(name = "failureHandler")
    public AuthenticationFailureHandler failureHandler() {
        return new SimpleUrlAuthenticationFailureHandler(Securities.defaultFailureUrl);
    }

    @Autowired
    @Override
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        super.setAuthenticationManager(authenticationManager);
    }

    @Autowired
    @Override
    public void setAuthenticationSuccessHandler(AuthenticationSuccessHandler successHandler) {
        super.setAuthenticationSuccessHandler(successHandler);
    }

    @Autowired
    @Override
    public void setAuthenticationFailureHandler(AuthenticationFailureHandler failureHandler) {
        super.setAuthenticationFailureHandler(failureHandler);
    }

    private String obtainCaptcha(HttpServletRequest request) {
        return request.getParameter(SECURITY_FORM_CAPTCHA_KEY);
    }

    private String getCaptchaFromSession(HttpServletRequest request) {
        return String.valueOf(request.getSession().getAttribute(Captcha.SESSION_KEY_OF_CAPTCHA_DEFAULT));
    }

}
