package easy.media.marketing.os.framework.api.model.weixin;

import javax.xml.bind.annotation.XmlElement;

/**
 * 菜单事件
 *
 * Created by zhoukai on 2016/4/28.
 */
public class MenuEvent extends Event {

    @XmlElement(name = "EventKey")
    private String eventkey;

    public String getEventkey() {
        return eventkey;
    }

    public void setEventkey(String eventkey) {
        this.eventkey = eventkey;
    }
}
