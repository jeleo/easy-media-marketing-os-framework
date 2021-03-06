package easy.media.marketing.os.framework.admin.controller;

import easy.media.marketing.os.framework.commons.utils.Captcha;
import easy.media.marketing.os.framework.commons.web.view.TrailingSlashRedirectView;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;

@Controller
public class GlobalController extends ControllerBus {

    @RequestMapping("")
    public TrailingSlashRedirectView redirectIndex() {
        return new TrailingSlashRedirectView("/");
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String toWhere() {
        return super.redirect(VIEW_DEFAULT);
    }

    @RequestMapping(value = VIEW_DEFAULT, method = RequestMethod.GET)
    public String toIndex() {
        return VIEW_DEFAULT;
    }

    @RequestMapping(value = "/captcha.html", method = RequestMethod.GET)
    public void getCaptcha(HttpServletRequest request, HttpServletResponse response) {
        Captcha.handle(request, response);
    }

}
