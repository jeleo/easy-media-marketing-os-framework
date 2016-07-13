package easy.media.marketing.os.framework.commons.web.security;

import easy.media.marketing.os.framework.commons.error.ErrorEntry;
import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Ajax登出
 * Created by jeleo on 2016/7/13.
 */
public class AjaxLogoutSuccessHandler implements LogoutSuccessHandler {

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        response.setHeader("Content-Type", "application/json;charset=UTF-8");
        ObjectMapper objectMapper = new ObjectMapper();
        JsonGenerator jsonGenerator = objectMapper.getJsonFactory().createJsonGenerator(response.getOutputStream(), JsonEncoding.UTF8);
        objectMapper.writeValue(jsonGenerator, ErrorEntry.e00000);
    }

}
