<#import "/spring.ftl" as spring />
<#assign base = "${rc.contextPath}">
<div class="container w-xxl w-auto-xs" ng-controller="SigninFormController" ng-init="app.settings.container = false;captchaUrl = '${base}/captcha.html'">
    <div class="navbar-brand block m-t">{{app.name}}</div>

    <div class="m-b-lg">
        <div class="wrapper text-center">
            <i class="icon icon-login"></i>
            <strong>运维管理</strong>
        </div>
        <form name="form" class="form-validation">
            <div class="text-danger wrapper text-center" ng-show="authError">
                {{authError}}
            </div>
            <div class="list-group list-group-sm">
                <div class="list-group-item">
                    <input type="text" placeholder="管理员" class="form-control no-border" name="username" ng-model="user.username" required>
                </div>
                <div class="list-group-item">
                    <input type="password" placeholder="密&emsp;码" class="form-control no-border" name="password" ng-model="user.password" required>
                </div>
                <div class="list-group-item">
                    <div class="row">
                        <div class="col-xs-7 col-sm-7 col-md-7">
                            <input type="text" placeholder="验证码" class="form-control no-border" name="captcha" ng-model="user.captcha" required>
                        </div>
                        <div class="col-xs-5 col-sm-5 col-md-5">
                            <img style="cursor: pointer;" ng-src="{{captchaUrl}}" ng-click="refresh()" />
                        </div>
                    </div>
                </div>
            </div>
            <button type="submit" class="btn btn-lg btn-primary btn-block" ng-click="login()" ng-disabled='form.$invalid'>登录</button>
        </form>
    </div>
    <div class="text-center" ng-include="'views/page_footer.html'">
        {% include 'blocks/page_footer.html' %}
    </div>
</div>