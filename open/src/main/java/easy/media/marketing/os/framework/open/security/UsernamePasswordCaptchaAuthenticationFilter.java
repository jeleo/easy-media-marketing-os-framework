package easy.media.marketing.os.framework.open.security;

import easy.media.marketing.os.framework.commons.error.ErrorString;
import easy.media.marketing.os.framework.commons.utils.Captcha;
import easy.media.marketing.os.framework.commons.web.security.AjaxAuthenticationFailureHandler;
import easy.media.marketing.os.framework.commons.web.security.AjaxAuthenticationSuccessHandler;
import easy.media.marketing.os.framework.open.model.Login;
import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class UsernamePasswordCaptchaAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    public static final String SECURITY_FORM_CAPTCHA_KEY = "captcha";

    public UsernamePasswordCaptchaAuthenticationFilter() {
        super.setFilterProcessesUrl(Securities.loginFilterProcessesUrl);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        String authType = request.getHeader("AuthType");
        String username, password, captcha;
        if (StringUtils.equals(authType, "ajax")) {
            super.setAuthenticationSuccessHandler(new AjaxAuthenticationSuccessHandler());
            super.setAuthenticationFailureHandler(new AjaxAuthenticationFailureHandler());

            try {
                Login login = new ObjectMapper().readValue(request.getInputStream(), Login.class);
                username = login.getUsername();
                password = login.getPassword();
                captcha = login.getCaptcha();
            } catch (IOException e) {
                throw new AuthenticationServiceException(ErrorString.e00002);
            }
        } else {
            super.setAuthenticationSuccessHandler(userLoginHandler);
            super.setAuthenticationFailureHandler(new SimpleUrlAuthenticationFailureHandler(Securities.defaultFailureUrl));

            captcha = this.obtainCaptcha(request);
            username = super.obtainUsername(request);
            password = super.obtainPassword(request);
        }
        if (StringUtils.isEmpty(captcha)) {
            throw new AuthenticationServiceException(ErrorString.e10000);
        }
        String captchaInSession = this.getCaptchaFromSession(request);
        if (!StringUtils.equalsIgnoreCase(captchaInSession, captcha)) {
            throw new AuthenticationServiceException(ErrorString.e10001);
        }
        if(username == null) {
            username = "";
        }

        if(password == null) {
            password = "";
        }
        username = username.trim();
        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);
        super.setDetails(request, authRequest);
        return super.getAuthenticationManager().authenticate(authRequest);
    }

    @Autowired
    @Override
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        super.setAuthenticationManager(authenticationManager);
    }

    private String obtainCaptcha(HttpServletRequest request) {
        return request.getParameter(SECURITY_FORM_CAPTCHA_KEY);
    }

    private String getCaptchaFromSession(HttpServletRequest request) {
        return String.valueOf(request.getSession().getAttribute(Captcha.SESSION_KEY_OF_CAPTCHA_DEFAULT));
    }

    @Autowired
    private UserLoginHandler userLoginHandler;

}
