package easy.media.marketing.os.framework.commons.constants.weixin;

import org.apache.commons.lang3.StringUtils;

/**
 * 微信事件类型
 *
 * Created by zhoukai on 2016/4/26.
 */
public enum EventType {

    VIEW("VIEW", "点击菜单跳转链接"),
    CLICK("CLICK", "点击菜单拉取消息"),
    LOCATION("LOCATION", "上报地理位置"),
    SCAN("SCAN", "扫描二维码"),
    subscribe("subscribe", "关注"),
    unsubscribe("unsubscribe", "取消关注");

    EventType(String value, String name) {
        this.value = value;
        this.name = name;
    }

    public static EventType getByValue(String value) {
        for (EventType eventType : EventType.values()) {
            if (StringUtils.equals(value, eventType.value)) {
                return eventType;
            }
        }
        return null;
    }

    public final String value;
    public final String name;
}
