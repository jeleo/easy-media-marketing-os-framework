package easy.media.marketing.os.framework.commons.error;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 错误提示基类
 * Created by jeleo on 2016/7/5.
 */
@XmlRootElement
public class ErrorInfo {

    private final static String ERRCODE = "errcode";

    private final static String ERRMSG = "errmsg";

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

    private final Integer errcode;
    private final String errmsg;

    public ErrorInfo(String errorString) {
        String[] _errorString = StringUtils.split(errorString, ",");
        this.errcode = Integer.parseInt(_errorString[0]);
        this.errmsg = _errorString[1];
    }

    public ErrorInfo(Integer errcode, String errmsg) {
        this.errcode = errcode;
        this.errmsg = errmsg;
    }

    @XmlElement(name = ERRCODE)
    public Integer getErrcode() {
        return errcode;
    }

    @XmlElement(name = ERRMSG)
    public String getErrmsg() {
        return errmsg;
    }
}
