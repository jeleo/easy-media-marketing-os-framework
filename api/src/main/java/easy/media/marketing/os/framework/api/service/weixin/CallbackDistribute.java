package easy.media.marketing.os.framework.api.service.weixin;

import easy.media.marketing.os.framework.api.exception.CheckSourceException;
import easy.media.marketing.os.framework.api.model.weixin.*;
import easy.media.marketing.os.framework.commons.constants.weixin.EventType;
import easy.media.marketing.os.framework.commons.constants.weixin.MsgType;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.scheduling.annotation.Async;

import java.io.IOException;

/**
 * 解析微信回调消息，适配处理流程
 *
 * Created by zhoukai on 2016/4/28.
 */
public abstract class CallbackDistribute {

    public CallbackDistribute() {
        this.jaxb2RootElementHttpMessageConverter = buildJaxb2RootElementHttpMessageConverter();
    }

    @Async
    public void adapt(HttpInputMessage input) {
        try {
            Callback message = this.read(Callback.class, input);
            if (StringUtils.equalsIgnoreCase(message.getMsgType(), MsgType.EVENT.value)) {
                Event event = this.read(Event.class, input);
                if (StringUtils.equalsIgnoreCase(event.getEvent(), EventType.subscribe.value)) {
                    SubscribeEvent subscribeEvent = this.read(SubscribeEvent.class, input);
                    this.process(subscribeEvent);
                } else if (StringUtils.equalsIgnoreCase(event.getEvent(), EventType.unsubscribe.value)) {
                    UnsubscribeEvent unsubscribeEvent = this.read(UnsubscribeEvent.class, input);
                    this.process(unsubscribeEvent);
                } else if (StringUtils.equalsIgnoreCase(event.getEvent(), EventType.CLICK.value)) {
                    MenuClickEvent menuClickEvent = this.read(MenuClickEvent.class, input);
                    this.process(menuClickEvent);
                } else if (StringUtils.equalsIgnoreCase(event.getEvent(), EventType.VIEW.value)) {
                    MenuLinkEvent menuLinkEvent = this.read(MenuLinkEvent.class, input);
                    this.process(menuLinkEvent);
                } else if (StringUtils.equalsIgnoreCase(event.getEvent(), EventType.LOCATION.value)) {
                    LocationEvent locationEvent = this.read(LocationEvent.class, input);
                    this.process(locationEvent);
                }
            } else if (StringUtils.equalsIgnoreCase(message.getMsgType(), MsgType.TEXT.value)) {
                TextMessage textMessage = this.read(TextMessage.class, input);
                this.process(textMessage);
            }
        } catch (IOException e) {
            logger.error("parse callback message failed", e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private <T extends Callback> T read(Class<T> messageType, HttpInputMessage input) throws IOException {
        return (T) this.jaxb2RootElementHttpMessageConverter.read(messageType, input);
    }

    private Jaxb2RootElementHttpMessageConverter buildJaxb2RootElementHttpMessageConverter() {
        return new Jaxb2RootElementHttpMessageConverter();
    }

    /**
     *  验证有效性
     *
     *  参考微信API接入指南，https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421135319&token=&lang=zh_CN
     * */
    public abstract void checkSource(String nonce, String timestamp, String signature) throws CheckSourceException;

    /**
     * 订阅事件
     * */
    protected abstract void process(SubscribeEvent subscribeEvent);

    /**
     * 取消订阅事件
     * */
    protected abstract void process(UnsubscribeEvent subscribeEvent);

    /**
     * 菜单点击事件
     * */
    protected abstract void process(MenuClickEvent menuClickEvent);

    /**
     * 菜单跳转事件
     * */
    protected abstract void process(MenuLinkEvent menuLinkEvent);

    /**
     * 上报地理位置
     * */
    protected abstract void process(LocationEvent locationEvent);

    /**
     * 文本消息
     * */
    protected abstract void process(TextMessage textMessage);

    private Jaxb2RootElementHttpMessageConverter jaxb2RootElementHttpMessageConverter;

    private static final Logger logger = LoggerFactory.getLogger(CallbackDistribute.class);
}
