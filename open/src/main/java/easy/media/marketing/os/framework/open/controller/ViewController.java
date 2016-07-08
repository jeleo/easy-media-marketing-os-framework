package easy.media.marketing.os.framework.open.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 视图控制器，用来引导前端angularjs中router的页面请求
 *
 * Created by jeleo on 2016/7/7.
 */
@Controller
@RequestMapping(Controllers.VIEW_ROOT)
public class ViewController extends ControllerBus {

    @RequestMapping(value = VIEW_APP, method = RequestMethod.GET)
    public String toApp() {
        return page(VIEW_APP);
    }

    @RequestMapping(value = VIEW_FOOTER, method = RequestMethod.GET)
    public String toFooter() {
        return layout(VIEW_FOOTER);
    }

    @RequestMapping(value = VIEW_LOGIN, method = RequestMethod.GET)
    public String toSignin() {
        return page(VIEW_LOGIN);
    }

    @RequestMapping(value = VIEW_FORGOTPWD, method = RequestMethod.GET)
    public String toForgotpwd() {
        return page(VIEW_FORGOTPWD);
    }

    private String layout(String path) {
        return "/tpl/blocks" + path;
    }

    private String page(String path) {
        return "/tpl" + path;
    }

}
