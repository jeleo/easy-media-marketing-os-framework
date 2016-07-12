package easy.media.marketing.os.framework.open.security;

import easy.media.marketing.os.framework.commons.utils.Captcha;
import easy.media.marketing.os.framework.open.model.Login;
import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectReader;
import org.codehaus.jackson.map.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.json.JsonObjectBuilder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;

@Component
public class UsernamePasswordCaptchaAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    public static final String SECURITY_FORM_CAPTCHA_KEY = "captcha";

    public UsernamePasswordCaptchaAuthenticationFilter() {
        super.setFilterProcessesUrl(Securities.loginFilterProcessesUrl);
        super.setAuthenticationFailureHandler(failureHandler());
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        String authType = request.getHeader("AuthType");
        String username, password, captcha;
        if (StringUtils.equals(authType, "ajax")) {
            try {
                Login login = new ObjectMapper().readValue(request.getInputStream(), Login.class);
                username = login.getUsername();
                password = login.getPassword();
                captcha = login.getCaptcha();
            } catch (IOException e) {
                throw new AuthenticationServiceException("登录参数不合法");
            }
        } else {
            captcha = this.obtainCaptcha(request);
            username = super.obtainUsername(request);
            password = super.obtainPassword(request);
        }
        if (StringUtils.isEmpty(captcha)) {
            throw new AuthenticationServiceException("验证码不允许为空");
        }
        String captchaInSession = this.getCaptchaFromSession(request);
        if (!StringUtils.equalsIgnoreCase(captchaInSession, captcha)) {
            throw new AuthenticationServiceException("验证码错误");
        }
        if(username == null) {
            username = "";
        }

        if(password == null) {
            password = "";
        }
        username = username.trim();
        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);
        this.setDetails(request, authRequest);
        return this.getAuthenticationManager().authenticate(authRequest);
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
