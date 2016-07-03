<#import "/spring.ftl" as spring />
<#assign base = "${rc.contextPath}">
<#assign resources = "${static_resources_url}">
<!DOCTYPE html>
<html lang="en" class="">
<head>
    <meta charset="utf-8"/>
    <title>Login | Easy Media Marketing OS</title>
    <meta name="description" content="app, web app, responsive, responsive layout, admin, admin panel, admin dashboard, flat, flat ui, ui kit, AngularJS, ui route, charts, widgets, components"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1"/>
    <link rel="stylesheet" href="${resources}/assets/vendor/present/animate.css/animate.css" type="text/css"/>
    <link rel="stylesheet" href="${resources}/assets/vendor/present/font-awesome/css/font-awesome.min.css" type="text/css"/>
    <link rel="stylesheet" href="${resources}/assets/vendor/present/simple-line-icons/css/simple-line-icons.css" type="text/css"/>
    <link rel="stylesheet" href="${resources}/assets/vendor/jquery/bootstrap/dist/css/bootstrap.css" type="text/css"/>

    <link rel="stylesheet" href="${resources}/assets/vendor/angulr-2.2/css/font.css" type="text/css"/>
    <link rel="stylesheet" href="${resources}/assets/vendor/angulr-2.2/css/app.css" type="text/css"/>

    <link rel="shortcut icon" href="${base}/assets/self/img/favicon.ico" />

</head>
<body>
<div class="app app-header-fixed ">

    <div class="container w-xxl w-auto-xs"  ng-app="app" ng-controller="signinFormController" ng-init="app.settings.container = false; captchaUrl = '${base}/captcha.html'">
        <a href class="navbar-brand block m-t">Easy Media Marketing OS</a>

        <div class="m-b-lg">
            <div class="wrapper text-center">
                <i class="icon icon-login"></i>
                <strong>账号登录</strong>
            </div>
            <form class="form-validation" name="form" action="${base}/auth/login" method="post">
                <#if Session.SPRING_SECURITY_LAST_EXCEPTION??>
                <div class="text-danger wrapper text-center">
                    ${Session.SPRING_SECURITY_LAST_EXCEPTION.message}
                </div>
                </#if>
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
                        <a ui-sref="access.forgotpwd">忘记密码?</a>
                    </div>
                    <div class="col-md-6">
                        <div class="row">
                            <div class="col-md-6">
                                <p class="text-right"><small>没有帐号,</small></p>
                            </div>
                            <div class="col-md-6">
                                <a href="register.html"><span class="text-info-lter">立即注册</span></a>
                            </div>
                        </div>
                    </div>
                </div>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
            </form>
        </div>
        <div class="text-center">
            <p>
                <small class="text-muted">开源新媒体管理系统<br>${copyright}</small>
            </p>
        </div>
    </div>

</div>

<script src="${resources}/assets/vendor/angular/angular/angular.js"></script>
<script src="${resources}/assets/vendor/jquery/jquery/dist/jquery.js"></script>
<script src="${resources}/assets/vendor/jquery/bootstrap/dist/js/bootstrap.js"></script>
<script src="${resources}/assets/vendor/angulr-2.2/js/ui-load.js"></script>
<script src="${resources}/assets/vendor/angulr-2.2/js/ui-jp.config.js"></script>
<script src="${resources}/assets/vendor/angulr-2.2/js/ui-jp.js"></script>
<script src="${resources}/assets/vendor/angulr-2.2/js/ui-nav.js"></script>
<script src="${resources}/assets/vendor/angulr-2.2/js/ui-toggle.js"></script>
<script src="${resources}/assets/vendor/angulr-2.2/js/ui-client.js"></script>
<script src="${resources}/assets/vendor/angular/angular-route/angular-route.js"></script>
<script src="${base}/assets/self/scripts/login.js"></script>

</body>
</html>
