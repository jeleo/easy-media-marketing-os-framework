package easy.media.marketing.os.framework.open.controller;

import easy.media.marketing.os.framework.commons.utils.Captcha;
import easy.media.marketing.os.framework.open.error.OpenErrorEntry;
import easy.media.marketing.os.framework.open.model.Register;
import easy.media.marketing.os.framework.open.service.OpenUserService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.Principal;

@RestController
@RequestMapping("/auth")
public class AuthorizeController extends ControllerBus {

    private static Logger logger = LoggerFactory.getLogger(AuthorizeController.class);

    @RequestMapping(value = "/register.json", method = RequestMethod.POST)
    public Object doRegister(@RequestBody @Valid Register register, BindingResult registerErrors, HttpSession session) {

        if(registerErrors.hasErrors()) {
            return super.convert(registerErrors.getFieldErrors());
        }

        if (!StringUtils.equals(register.getPassword(), register.getPasswordConfirmed())) {
            return OpenErrorEntry.e20002;
        }

        String captchaInSession = String.valueOf(session.getAttribute(Captcha.SessionKey.REGISTER.value));
        if (StringUtils.equals(register.getCaptcha(), captchaInSession)) {
            return OpenErrorEntry.e10001;
        }

        if (openUserService.getOneByUsername(register.getUsername()) != null) {
            return OpenErrorEntry.e20003;
        }

        if (openUserService.getOneByEmail(register.getEmail()) != null) {
            return OpenErrorEntry.e20004;
        }

        try {
            openUserService.create(register.getUsername(), register.getPassword(), register.getEmail());
        } catch (Exception e) {
            logger.error("register failed, " + register, e);
            return OpenErrorEntry.e00001;
        }

        return OpenErrorEntry.e00000;
    }

    @RequestMapping(value = "/isAuthenticated.json", method = RequestMethod.GET)
    public Object isAuthenticated(Principal pricinpal) {
        return pricinpal == null ? OpenErrorEntry.e10010 : OpenErrorEntry.e00000;
    }

    @Autowired
    private OpenUserService openUserService;

}
