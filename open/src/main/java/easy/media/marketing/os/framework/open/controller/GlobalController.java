package easy.media.marketing.os.framework.open.controller;

import easy.media.marketing.os.framework.commons.utils.Captcha;
import easy.media.marketing.os.framework.commons.web.view.TrailingSlashRedirectView;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String toWhere(Principal pricinpal, ModelMap model) {
//        if (pricinpal != null) {
//            return PATH_REDIRECT_DASHBOARD;
//        } else {
//            return VIEW_DEFAULT;
//        }
        return super.redirect(VIEW_DEFAULT);
    }

    @RequestMapping(value = VIEW_DEFAULT, method = RequestMethod.GET)
    public String toIndex() {
        return VIEW_DEFAULT;
    }

    @RequestMapping(value = "/captcha.html", method = RequestMethod.GET)
    public void getCaptcha(@RequestParam(value = "type", required = false) String type, HttpServletRequest request, HttpServletResponse response) {
        if (StringUtils.isNotEmpty(type)) {
            switch (type) {
                case "register" :
                    Captcha.handle(request, response, Captcha.SessionKey.REGISTER.value);
                    break;
                default:
                    break;
            }
        } else {
            Captcha.handle(request, response);
        }
    }

}
