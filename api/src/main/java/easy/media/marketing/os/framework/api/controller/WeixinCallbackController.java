package easy.media.marketing.os.framework.api.controller;

import easy.media.marketing.os.framework.api.form.weixin.WeixinSignature;
import easy.media.marketing.os.framework.api.service.weixin.CallbackDistribute;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpInputMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/weixin")
public class WeixinCallbackController extends CallbackController {

    /**
     * 公众号首次配置回调地址时
     * */
    @RequestMapping(value = "/", params = "echostr")
    @ResponseBody
    public String validate(WeixinSignature form, @RequestParam("echostr") String echostr) throws Exception {
        String nonce = form.getNonce();
        String timestamp = form.getTimestamp();
        String signature = form.getSignature();

        try {
            // 有效性校验
            this.callbackDistribute.checkSource(nonce, timestamp, signature);
            return echostr;
        } catch (Exception e) {
            logger.error("process weixin callback failed.", e);
            throw e;
        }
    }

    /**
     * 公众号回调消息接收
     * */
    @RequestMapping(value = "/", params = "!echostr")
    @ResponseBody
    public Object callback(WeixinSignature form, HttpEntity<String> entity) throws Exception {
        String nonce = form.getNonce();
        String timestamp = form.getTimestamp();
        String signature = form.getSignature();
        try {
            // 有效性校验
            this.callbackDistribute.checkSource(nonce, timestamp, signature);
            HttpInputMessage input = new CallbackXmlInput(entity);
            // 回调消息适配
            this.callbackDistribute.adapt(input);
            // 微信服务器在五秒内收不到响应会断掉连接，并且重新发起请求，总共重试三次。
            // 假如服务器无法保证在五秒内处理并回复，可以直接回复空串，微信服务器不会对此作任何处理，并且不会发起重试。
            return "";
        } catch (Exception e) {
            logger.error("process weixin callback failed.", e);
            throw e;
        }
    }

    @Autowired
    private CallbackDistribute callbackDistribute;

    private static final Logger logger = LoggerFactory.getLogger(WeixinCallbackController.class);

}
