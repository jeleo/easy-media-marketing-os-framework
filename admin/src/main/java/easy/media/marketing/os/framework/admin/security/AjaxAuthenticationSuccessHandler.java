package easy.media.marketing.os.framework.admin.security;

import easy.media.marketing.os.framework.commons.error.ErrorEntry;
import easy.media.marketing.os.framework.commons.utils.HttpServletUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Ajax登录成功
 *
 * Created by jeleo on 16-7-12.
 */
public class AjaxAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        HttpServletUtils.writeJson(response, ErrorEntry.e00000);
    }


}
