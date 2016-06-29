package easy.media.marketing.os.framework.admin.security;

public interface Securities {

    String loginFormUrl = "/auth/login.html";
    String loginFilterProcessesUrl = "/auth/login";
    String logoutFilterProcessesUrl = "/auth/logout";
    String logoutSuccessUrl = loginFormUrl + "?logout";
    String defaultFailureUrl = loginFormUrl + "?error";
    String defaultTargetUrl = "/index.html";

}
