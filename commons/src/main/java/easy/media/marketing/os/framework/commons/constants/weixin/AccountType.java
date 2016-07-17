package easy.media.marketing.os.framework.commons.constants.weixin;

import org.apache.commons.lang3.StringUtils;

/**
 * 公众号类型
 *
 * Created by jeleo on 2016/7/15.
 */
public enum AccountType {

    SERVICE("服务号", "service"),
    SUBSCRIPTION("订阅号", "subscription");

    AccountType(String display, String value) {
        this.display = display;
        this.value = value;
    }

    public static AccountType match(String value) {
        for (AccountType accountType : AccountType.values()) {
            if (StringUtils.equals(accountType.value, value)) {
                return accountType;
            }
        }
        throw new IllegalArgumentException(String.format("未能使用 %s 找到对应的枚举对象", value));
    }

    public String display;
    public String value;

}
