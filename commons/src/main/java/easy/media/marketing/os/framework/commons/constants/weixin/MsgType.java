package easy.media.marketing.os.framework.commons.constants.weixin;

import org.apache.commons.lang3.StringUtils;

/**
 * 微信消息类型
 *
 * Created by zhoukai on 2016/4/29.
 */
public enum MsgType {

    EVENT("event", "事件推送"),
    TEXT("text", "文本消息"),
    IMAGE("image", "图片消息"),
    VOICE("voice", "语音消息"),
    VIDEO("video", "视频消息"),
    SHORTVIDEO("shortvideo", "小视频消息"),
    LOCATION("location", "地理位置消息"),
    LINK("link", "链接消息");

    MsgType(String value, String name) {
        this.value = value;
        this.name = name;
    }

    public static MsgType getByValue(String value) {
        for (MsgType msgType : MsgType.values()) {
            if (StringUtils.equals(value, msgType.value)) {
                return msgType;
            }
        }
        return null;
    }

    public final String value;
    public final String name;
}
