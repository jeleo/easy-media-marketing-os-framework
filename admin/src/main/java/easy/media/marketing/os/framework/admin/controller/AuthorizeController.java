package easy.media.marketing.os.framework.admin.controller;

import easy.media.marketing.os.framework.commons.web.view.TrailingSlashRedirectView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/auth")
public class AuthorizeController extends ControllerBus {

    @RequestMapping("")
    public TrailingSlashRedirectView redirectIndex() {
        return new TrailingSlashRedirectView("/auth/login.html");
    }

    @RequestMapping(value = "/login.html", method = RequestMethod.GET)
    public String toLogin() {
        return PATH_AUTH_LOGIN;
    }

}
