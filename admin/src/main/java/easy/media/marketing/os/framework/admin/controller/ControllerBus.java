package easy.media.marketing.os.framework.admin.controller;

import easy.media.marketing.os.framework.commons.error.ErrorEntry;
import easy.media.marketing.os.framework.commons.error.ErrorInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.FieldError;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 控制器总线
 */
public abstract class ControllerBus implements Controllers {

    private final static String USER_AGENT = "User-Agent";

    protected final static String[] mobileAgents = { "iphone", "android", "phone", "mobile", "wap", "netfront", "java", "opera mobi", "opera mini", "ucweb",
            "windows ce", "symbian", "series", "webos", "sony", "blackberry", "dopod", "nokia", "samsung", "palmsource", "xda", "pieplus", "meizu", "midp",
            "cldc", "motorola", "foma", "docomo", "up.browser", "up.link", "blazer", "helio", "hosin", "huawei", "novarra", "coolpad", "webos", "techfaith",
            "palmsource", "alcatel", "amoi", "ktouch", "nexian", "ericsson", "philips", "sagem", "wellcom", "bunjalloo", "maui", "smartphone", "iemobile",
            "spice", "bird", "zte-", "longcos", "pantech", "gionee", "portalmmm", "jig browser", "hiptop", "benq", "haier", "^lct", "320x320", "240x320",
            "176x220", "w3c ", "acs-", "alav", "alca", "amoi", "audi", "avan", "benq", "bird", "blac", "blaz", "brew", "cell", "cldc", "cmd-", "dang", "doco",
            "eric", "hipt", "inno", "ipaq", "java", "jigs", "kddi", "keji", "leno", "lg-c", "lg-d", "lg-g", "lge-", "maui", "maxo", "midp", "mits", "mmef",
            "mobi", "mot-", "moto", "mwbp", "nec-", "newt", "noki", "oper", "palm", "pana", "pant", "phil", "play", "port", "prox", "qwap", "sage", "sams",
            "sany", "sch-", "sec-", "send", "seri", "sgh-", "shar", "sie-", "siem", "smal", "smar", "sony", "sph-", "symb", "t-mo", "teli", "tim-", "tosh",
            "tsm-", "upg1", "upsi", "vk-v", "voda", "wap-", "wapa", "wapi", "wapp", "wapr", "webc", "winw", "winw", "xda", "xda-", "Googlebot-Mobile" };

    public static boolean isMobile(HttpServletRequest request) {
        boolean isMobile = false;
        String userAgent = request.getHeader(USER_AGENT);
        if (StringUtils.isNotEmpty(userAgent)) {
            for (String mobileAgent : mobileAgents) {
                if (userAgent.toLowerCase().contains(mobileAgent)) {
                    isMobile = true;
                    break;
                }
            }
        }
        return isMobile;
    }

    protected String redirect(String url) {
        return "redirect:" + url;
    }

    protected ErrorInfo convert(List<FieldError> fieldErrors) {
        // 暂时只处理一条错误提示
        return ErrorEntry.build(fieldErrors.get(0).getDefaultMessage());
    }

}
