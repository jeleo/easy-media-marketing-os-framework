package easy.media.marketing.os.framework.open.service;

import easy.media.marketing.os.framework.commons.constants.weixin.AccountType;
import easy.media.marketing.os.framework.open.entity.WeixinChannel;
import easy.media.marketing.os.framework.open.repository.WeixinChannelRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * Created by jeleo on 16-7-15.
 */
@Service
public class WeixinChannelServiceImpl implements WeixinChannelService {

    @Override
    public List<WeixinChannel> findByUserUid(String userUid) {
        return weixinChannelRepository.findByUserUid(userUid);
    }

    @Override
    public WeixinChannel create(String userUid, String name, String openId, String appId, String appSecret, AccountType accountType, String weixinAccount, String comment) {
        WeixinChannel weixinChannel = new WeixinChannel();
        weixinChannel.setUserUid(userUid);
        weixinChannel.setName(name);
        weixinChannel.setOpenId(openId);
        weixinChannel.setAppId(appId);
        weixinChannel.setAppSecret(appSecret);
        weixinChannel.setAccountType(accountType);
        if (StringUtils.isNotEmpty(weixinAccount)) {
            weixinChannel.setWeixinAccount(weixinAccount);
        }
        if (StringUtils.isNotEmpty(comment)) {
            weixinChannel.setComment(comment);
        }
        // callback为openId的base64加密
        String callback = new String(Base64.encode(openId.getBytes(StandardCharsets.UTF_8)));
        weixinChannel.setCallback(callback);
        // token为长度是8的字母和数字的随机组合字符串
        String token = RandomStringUtils.randomAlphanumeric(8);
        weixinChannel.setToken(token);
        return weixinChannelRepository.save(weixinChannel);
    }

    @Override
    public WeixinChannel update(Long id, String name, String appId, String appSecret, AccountType accountType, String weixinAccount, String comment) {
        WeixinChannel weixinChannel = weixinChannelRepository.getOne(id);
        weixinChannel.setName(name);
        weixinChannel.setAppId(appId);
        weixinChannel.setAppSecret(appSecret);
        weixinChannel.setAccountType(accountType);
        weixinChannel.setWeixinAccount(weixinAccount);
        weixinChannel.setComment(comment);
        return weixinChannelRepository.save(weixinChannel);
    }

    @Override
    public void deleteById(Long id) {
        weixinChannelRepository.delete(id);
    }

    @Override
    public String resetToken(Long id) {
        String token = RandomStringUtils.randomAlphanumeric(8);
        weixinChannelRepository.updateToken(token, id);
        return token;
    }

    @Override
    public WeixinChannel getOneById(Long id) {
        return weixinChannelRepository.getOne(id);
    }

    @Autowired
    private WeixinChannelRepository weixinChannelRepository;
}
