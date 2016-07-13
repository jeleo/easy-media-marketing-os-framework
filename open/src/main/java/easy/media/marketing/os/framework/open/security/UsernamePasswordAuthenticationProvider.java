package easy.media.marketing.os.framework.open.security;

import easy.media.marketing.os.framework.commons.error.ErrorString;
import easy.media.marketing.os.framework.open.entity.OpenUser;
import easy.media.marketing.os.framework.open.service.OpenUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class UsernamePasswordAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        // 在这里可以做额外参数验证
    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        String password = String.valueOf(authentication.getCredentials());
        OpenUser openUser = openUserService.loginByUsername(username, password);
        if (openUser == null) {
            throw new AuthenticationServiceException(ErrorString.e10011);
        }
        return new SecurityUser(openUser);
    }

    @Autowired
    private OpenUserService openUserService;
}
