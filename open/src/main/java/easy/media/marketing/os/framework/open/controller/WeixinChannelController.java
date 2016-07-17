package easy.media.marketing.os.framework.open.controller;

import easy.media.marketing.os.framework.commons.constants.weixin.AccountType;
import easy.media.marketing.os.framework.open.entity.WeixinChannel;
import easy.media.marketing.os.framework.open.error.OpenErrorEntry;
import easy.media.marketing.os.framework.open.model.WeixinSetup;
import easy.media.marketing.os.framework.open.service.WeixinChannelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jeleo on 16-7-15.
 */
@RestController
@RequestMapping("/weixin")
public class WeixinChannelController extends ControllerBus {

    private static Logger logger = LoggerFactory.getLogger(WeixinChannelController.class);

    @RequestMapping(value = "/add.json", method = RequestMethod.POST)
    public Object addChannel(@RequestBody WeixinSetup weixinSetup) {
        try {
            weixinChannelService.create(super.getFromSession().getUid(), weixinSetup.getName(), weixinSetup.getOpenId(), weixinSetup.getAppId(), weixinSetup.getAppSecret(), AccountType.match(weixinSetup.getAccountType().getValue()), weixinSetup.getWeixinAccount(), weixinSetup.getComment());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return OpenErrorEntry.e00001;
        }
        return OpenErrorEntry.e00000;
    }

    @RequestMapping(value = "/edit.json", method = RequestMethod.POST)
    public Object editChannel() {
        return null;
    }

    @RequestMapping(value = "/delete.json", method = RequestMethod.POST)
    public Object deleteChannel() {
        return null;
    }

    @RequestMapping(value = "/list.json", method = RequestMethod.GET)
    public Object listChannels() {
        List<WeixinSetup> channels = new ArrayList<>();
        for(WeixinChannel weixinChannel : weixinChannelService.findByUserUid(super.getFromSession().getUid())) {
            channels.add(WeixinSetup.convert(weixinChannel));
        }
        return channels;
    }

    @RequestMapping(value = "/get.json", method = RequestMethod.GET)
    public Object getChannel(@RequestParam(value = "id", required = true) Long id) {
        return WeixinSetup.convert(weixinChannelService.getOneById(id));
    }

    @Autowired
    private WeixinChannelService weixinChannelService;

}
