<#import "/spring.ftl" as spring />
<#assign base = "${rc.contextPath}">
<div class="container w-xxl w-auto-xs" ng-controller="SigninFormController" ng-init="app.settings.container = false;captchaUrl = '${base}/captcha.html'">
    <a href class="navbar-brand block m-t">{{app.name}}</a>

    <div class="m-b-lg">
        <div class="wrapper text-center">
            <i class="icon icon-login"></i>
            <strong>账号登录</strong>
        </div>
        <form name="form" class="form-validation">
            <div class="text-danger wrapper text-center" ng-show="authError">
                {{authError}}
            </div>
            <div class="list-group list-group-sm">
                <div class="list-group-item">
                    <input type="text" placeholder="用户名" class="form-control no-border" name="username" ng-model="username" required>
                </div>
                <div class="list-group-item">
                    <input type="password" placeholder="密&emsp;码" class="form-control no-border" name="password" ng-model="password" required>
                </div>
                <div class="list-group-item">
                    <div class="row">
                        <div class="col-xs-7 col-sm-7 col-md-7">
                            <input type="text" placeholder="验证码" class="form-control no-border" name="captcha" ng-model="captcha" required>
                        </div>
                        <div class="col-xs-5 col-sm-5 col-md-5">
                            <img style="cursor: pointer;" ng-src="{{captchaUrl}}" ng-click="refresh()" />
                        </div>
                    </div>
                </div>
            </div>
            <button type="submit" class="btn btn-lg btn-primary btn-block" ng-click="login()" ng-disabled='form.$invalid'>登录</button>
            <div class="line line-dashed"></div>
            <div class="row">
                <div class="col-md-6">
                    <a ui-sref="access.forgotpwd"><small>忘记密码?</small></a>
                </div>
                <div class="col-md-6">
                    <div class="row">
                        <div class="col-md-6">
                            <p class="text-right"><small>没有帐号,</small></p>
                        </div>
                        <div class="col-md-6">
                            <a ui-sref="access.signup"><span class="text-info-lter">立即注册</span></a>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </div>
    <div class="text-center" ng-include="'views/page_footer.html'">
        {% include 'blocks/page_footer.html' %}
    </div>
</div>