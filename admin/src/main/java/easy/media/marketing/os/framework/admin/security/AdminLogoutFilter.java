package easy.media.marketing.os.framework.admin.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Component;

@Component
public class AdminLogoutFilter extends LogoutFilter {

    @Autowired
    public AdminLogoutFilter(AdminLogoutHandler adminLogoutHandler) {
        super(Securities.logoutSuccessUrl, new SecurityContextLogoutHandler(), adminLogoutHandler);
        super.setFilterProcessesUrl(Securities.logoutFilterProcessesUrl);
    }

}
