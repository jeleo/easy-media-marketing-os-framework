package easy.media.marketing.os.framework.commons.web.security;

import easy.media.marketing.os.framework.commons.error.ErrorEntry;
import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;
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
        response.setHeader("Content-Type", "application/json;charset=UTF-8");
        ObjectMapper objectMapper = new ObjectMapper();
        JsonGenerator jsonGenerator = objectMapper.getJsonFactory().createJsonGenerator(response.getOutputStream(), JsonEncoding.UTF8);
        objectMapper.writeValue(jsonGenerator, ErrorEntry.build(exception.getMessage()));
    }

}
