package easy.media.marketing.os.framework.api.service.weixin;

import easy.media.marketing.os.framework.api.exception.CheckSourceException;
import easy.media.marketing.os.framework.api.model.weixin.*;
import org.springframework.stereotype.Service;

/**
 * 回调适配处理的实现类
 */
@Service
public class CallbackDistributeImpl extends CallbackDistribute {

    @Override
    public void checkSource(String nonce, String timestamp, String signature) throws CheckSourceException {

    }

    @Override
    protected void process(SubscribeEvent subscribeEvent) {

    }

    @Override
    protected void process(UnsubscribeEvent subscribeEvent) {

    }

    @Override
    protected void process(MenuClickEvent menuClickEvent) {

    }

    @Override
    protected void process(MenuLinkEvent menuLinkEvent) {

    }

    @Override
    protected void process(LocationEvent locationEvent) {

    }

    @Override
    protected void process(TextMessage textMessage) {

    }

}
