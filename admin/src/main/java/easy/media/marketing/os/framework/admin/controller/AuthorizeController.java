package easy.media.marketing.os.framework.admin.controller;

import easy.media.marketing.os.framework.admin.error.AdminErrorEntry;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/auth")
public class AuthorizeController extends ControllerBus {

    @RequestMapping(value = "/isAuthenticated.json", method = RequestMethod.GET)
    public Object isAuthenticated(Principal pricinpal) {
        return pricinpal == null ? AdminErrorEntry.e10010 : AdminErrorEntry.e00000;
    }

}
