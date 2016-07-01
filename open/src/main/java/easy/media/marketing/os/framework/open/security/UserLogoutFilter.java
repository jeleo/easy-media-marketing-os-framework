package easy.media.marketing.os.framework.open.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Component;

@Component
public class UserLogoutFilter extends LogoutFilter {

    @Autowired
    public UserLogoutFilter(UserLogoutHandler userLogoutHandler) {
        super(Securities.logoutSuccessUrl, new SecurityContextLogoutHandler(), userLogoutHandler);
        super.setFilterProcessesUrl(Securities.logoutFilterProcessesUrl);
    }

}
