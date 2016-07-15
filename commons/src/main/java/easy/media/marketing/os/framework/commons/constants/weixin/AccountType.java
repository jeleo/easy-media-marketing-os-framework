package easy.media.marketing.os.framework.commons.constants.weixin;

/**
 * 公众号类型
 *
 * Created by jeleo on 2016/7/15.
 */
public enum AccountType {

    SERVICE("service"),
    SUBSCRIPTION("subscription");

    AccountType(String value) {
        this.value = value;
    }

    public String value;

}
