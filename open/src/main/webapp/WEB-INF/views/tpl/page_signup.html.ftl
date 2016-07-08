<#import "/spring.ftl" as spring />
<#assign base = "${rc.contextPath}">
<div class="container w-xxl w-auto-xs" ng-controller="SignupFormController" ng-init="app.settings.container = false; captchaUrl = '${base}/captcha.html?type=register'">
    <a href class="navbar-brand block m-t">{{app.name}}</a>

    <div class="m-b-lg">
        <div class="wrapper text-center">
            <i class="icon icon-note"></i>
            <strong>用户注册</strong>
        </div>
        <form name="form" class="form-validation">
            <div class="text-danger wrapper text-center" ng-show="authError">
                {{authError}}
            </div>
            <div class="list-group list-group-sm">
                <div class="list-group-item">
                    <input name="username" placeholder="用&ensp;户&ensp;名" class="form-control no-border" ng-model="user.username" required>
                </div>
                <div class="list-group-item">
                    <input name="email" type="email" placeholder="邮&emsp;&emsp;箱" class="form-control no-border" ng-model="user.email" required>
                </div>
                <div class="list-group-item">
                    <input name="password" type="password" placeholder="设置密码" class="form-control no-border" ng-model="user.password" required>
                </div>
                <div class="list-group-item">
                    <input name="passwordConfirmed" type="password" placeholder="确认密码" class="form-control no-border" ng-model="user.passwordConfirmed" required>
                </div>
                <div class="list-group-item">
                    <div class="row">
                        <div class="col-xs-7 col-sm-7 col-md-7">
                            <input type="text" placeholder="验&ensp;证&ensp;码" class="form-control no-border" name="captcha" ng-model="user.captcha" required>
                        </div>
                        <div class="col-xs-5 col-sm-5 col-md-5">
                            <img style="cursor: pointer;" ng-src="{{captchaUrl}}" ng-click="refresh()" />
                        </div>
                    </div>
                </div>
            </div>
            <div class="checkbox m-b-md m-t-none">
                <label class="i-checks">
                    <input type="checkbox" ng-model="agree" required><i></i> 我已阅读并同意 <a ng-click="showTerms()">《使用条款》</a>
                </label>
            </div>
            <button type="submit" class="btn btn-lg btn-primary btn-block" ng-click="signup()" ng-disabled='form.$invalid'>注册</button>
            <div class="line line-dashed"></div>
            <div class="row">
                <div class="col-md-6">
                    <p class="text-right">
                        <small>我已经注册,</small>
                    </p>
                </div>
                <div class="col-md-6">
                    <a ui-sref="access.signin"><span class="text-info-lter">马上登录</span></a>
                </div>
            </div>
        </form>
    </div>
    <div class="text-center" ng-include="'views/page_footer.html'">
        {% include 'blocks/page_footer.html' %}
    </div>
</div>