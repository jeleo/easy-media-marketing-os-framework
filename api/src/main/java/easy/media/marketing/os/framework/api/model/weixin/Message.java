package easy.media.marketing.os.framework.api.model.weixin;

import javax.xml.bind.annotation.XmlElement;

/**
 * 回调消息基类
 * Created by zhoukai on 2016/4/28.
 */
public class Message extends Callback {

    @XmlElement(name = "MsgId")
    private String msgId;

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }
}
