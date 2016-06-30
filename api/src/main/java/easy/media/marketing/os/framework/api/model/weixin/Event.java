package easy.media.marketing.os.framework.api.model.weixin;

import javax.xml.bind.annotation.XmlElement;

/**
 * 回调事件基类
 *
 * Created by zhoukai on 2016/4/28.
 */
public class Event extends Callback {

    /**
     * 事件类型
     * */
    @XmlElement(name = "Event")
    private String event;

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }
}
