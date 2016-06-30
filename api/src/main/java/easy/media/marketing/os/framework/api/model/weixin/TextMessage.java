package easy.media.marketing.os.framework.api.model.weixin;

import javax.xml.bind.annotation.XmlElement;

/**
 * 文本消息
 *
 * Created by zhoukai on 2016/4/28.
 */
public class TextMessage extends Message {

    @XmlElement(name = "Content")
    private String content;

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
