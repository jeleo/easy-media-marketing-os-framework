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
@RequestMapping(Controllers.VIEW_URL_ROOT)
public class ViewController extends ControllerBus {

    @RequestMapping(value = "/app.html", method = RequestMethod.GET)
    public String toApp() {
        return VIEW_URL_APP;
    }

}
