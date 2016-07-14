package easy.media.marketing.os.framework.open.security;

import easy.media.marketing.os.framework.open.entity.OpenUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;
import java.util.Collection;

public class SecurityUser extends User{

    private OpenUser loginUser;

    public SecurityUser(OpenUser loginUser) {
        super(loginUser.getUsername(), loginUser.getPassword(), loginUser.getEnabled().value, true, true, true, new ArrayList<GrantedAuthority>());
        this.setLoginUser(loginUser);
    }

    public OpenUser getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(OpenUser loginUser) {
        this.loginUser = loginUser;
    }
}
