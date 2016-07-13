package easy.media.marketing.os.framework.open.security;

import easy.media.marketing.os.framework.commons.error.ErrorEntry;
import easy.media.marketing.os.framework.commons.utils.HttpServletUtils;
import easy.media.marketing.os.framework.open.service.OpenUserTrackService;
import org.springframework.beans.factory.annotation.Autowired;
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
        SecurityUser authenticatedUser = (SecurityUser) authentication.getPrincipal();
        openUserTrackService.create(authenticatedUser.getLoginUser().getUid(), HttpServletUtils.getIpAddress(request), request.getHeader("User-Agent"));
        HttpServletUtils.writeJson(response, ErrorEntry.e00000);
    }

    @Autowired
    private OpenUserTrackService openUserTrackService;

}
