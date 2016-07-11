package easy.media.marketing.os.framework.commons.error;

/**
 * 错误提示基类
 * Created by jeleo on 2016/7/5.
 */
public class ErrorEntry {

    public static ErrorInfo build(String errorString) {
        return new ErrorInfo(errorString);
    }

    /**
     * 通用的系统错误
     * */
    public final static ErrorInfo e00000 = new ErrorInfo(ErrorString.e00000);

    public final static ErrorInfo e00001 = new ErrorInfo(ErrorString.e00001);

    /**
     * 通用的业务错误
     * */
    public final static ErrorInfo e10000 = new ErrorInfo(ErrorString.e10000);

    public final static ErrorInfo e10001 = new ErrorInfo(ErrorString.e10001);

    public final static ErrorInfo e10002 = new ErrorInfo(ErrorString.e10002);

    public final static ErrorInfo e10003 = new ErrorInfo(ErrorString.e10003);

    public final static ErrorInfo e10004 = new ErrorInfo(ErrorString.e10004);

    public final static ErrorInfo e10005 = new ErrorInfo(ErrorString.e10005);

    public final static ErrorInfo e10006 = new ErrorInfo(ErrorString.e10006);

    public final static ErrorInfo e10007 = new ErrorInfo(ErrorString.e10007);

    public final static ErrorInfo e10008 = new ErrorInfo(ErrorString.e10008);

    public final static ErrorInfo e10009 = new ErrorInfo(ErrorString.e10009);

    public final static ErrorInfo e10010 = new ErrorInfo(ErrorString.e10010);
}
