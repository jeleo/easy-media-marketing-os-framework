package easy.media.marketing.os.framework.resources.controller;

import easy.media.marketing.os.framework.commons.web.view.TrailingSlashRedirectView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GlobalController {

    @RequestMapping("")
    public TrailingSlashRedirectView redirectIndex() {
        return new TrailingSlashRedirectView("/");
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Object toWhere() {
        return Controllers.PATH_REDIRECT_INDEX;
    }

    @RequestMapping(value = "/index.html", method = RequestMethod.GET)
    public String toIndex() {
        return Controllers.PATH_INDEX;
    }

}
