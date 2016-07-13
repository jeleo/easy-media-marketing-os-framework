package easy.media.marketing.os.framework.open.security;

import easy.media.marketing.os.framework.commons.error.ErrorEntry;
import easy.media.marketing.os.framework.commons.utils.HttpServletUtils;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Ajax登录失败
 *
 * Created by jeleo on 16-7-12.
 */
public class AjaxAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        HttpServletUtils.writeJson(response, ErrorEntry.build(exception.getMessage()));
    }

}
