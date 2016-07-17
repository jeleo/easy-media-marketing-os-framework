package easy.media.marketing.os.framework.open.controller;

import easy.media.marketing.os.framework.commons.constants.weixin.AccountType;
import easy.media.marketing.os.framework.open.model.EnumHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * Created by jeleo on 16-7-17.
 */
@RestController
@RequestMapping("/constants")
public class ConstantsController {

    @RequestMapping(value = "/weixin/accountType.json", method = RequestMethod.GET)
    public Object getWeixinAccountType() {
        return Arrays.asList(new EnumHelper(AccountType.SERVICE.display, AccountType.SERVICE.value), new EnumHelper(AccountType.SUBSCRIPTION.display, AccountType.SUBSCRIPTION.value));
    }

}
