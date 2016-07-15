package easy.media.marketing.os.framework.open.service;

import easy.media.marketing.os.framework.commons.constants.weixin.AccountType;
import easy.media.marketing.os.framework.open.entity.WeixinChannel;

import java.util.List;

/**
 * 微信渠道服务
 *
 * Created by jeleo on 16-7-15.
 */
public interface WeixinChannelService {

    List<WeixinChannel> findByUserUid(String userUid);

    WeixinChannel create(String userUid, String name, String openId, String appId, String appSecret, AccountType accountType, String weixinAccount, String comment);

    WeixinChannel update(Long id, String name, String appId, String appSecret, AccountType accountType, String weixinAccount, String comment);

    void deleteById(Long id);

    String resetToken(Long id);

}
