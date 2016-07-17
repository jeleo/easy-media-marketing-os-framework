package easy.media.marketing.os.framework.open.model;

import easy.media.marketing.os.framework.open.entity.WeixinChannel;
import org.springframework.beans.BeanUtils;

/**
 * Created by jeleo on 16-7-17.
 */
public class WeixinSetup {

    private Long id;
    private String name;
    private String openId;
    private String appId;
    private String appSecret;
    private EnumHelper accountType;
    private String weixinAccount;
    private String comment;
    private String callback;
    private String token;

    public static WeixinSetup convert(WeixinChannel weixinChannel) {
        WeixinSetup weixinSetup = new WeixinSetup();
        BeanUtils.copyProperties(weixinChannel, weixinSetup, "accountType");
        weixinSetup.setAccountType(new EnumHelper(weixinChannel.getAccountType().display, weixinChannel.getAccountType().value));
        return weixinSetup;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public EnumHelper getAccountType() {
        return accountType;
    }

    public void setAccountType(EnumHelper accountType) {
        this.accountType = accountType;
    }

    public String getWeixinAccount() {
        return weixinAccount;
    }

    public void setWeixinAccount(String weixinAccount) {
        this.weixinAccount = weixinAccount;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCallback() {
        return callback;
    }

    public void setCallback(String callback) {
        this.callback = callback;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
