package easy.media.marketing.os.framework.open.security;

public interface Securities {

    String loginFormUrl = "/index.html#/access/signin";
    String loginFilterProcessesUrl = "/auth/login";
    String logoutFilterProcessesUrl = "/auth/logout";
    String logoutSuccessUrl = loginFormUrl + "?logout";
    String defaultFailureUrl = loginFormUrl + "?error";
    String defaultTargetUrl = "/index.html#";

}
