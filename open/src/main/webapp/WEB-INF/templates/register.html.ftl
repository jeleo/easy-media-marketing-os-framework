<#import "/spring.ftl" as spring />
<#assign base = "${rc.contextPath}">
<#assign resources = "${static_resources_url}">
<!DOCTYPE html>
<html lang="en" class="">
<head>
    <meta charset="utf-8"/>
    <title>Register | Easy Media Marketing OS</title>
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


    <div class="container w-xxl w-auto-xs" ng-app="app" ng-controller="signupFormController" ng-init="app.settings.container = false;captchaUrl='${base}/captcha.html?type=register';authError=false">
        <a href class="navbar-brand block m-t">Easy Media Marketing OS</a>

        <div class="m-b-lg">
            <div class="wrapper text-center">
                <i class="icon icon-note"></i>
                <strong>用户注册</strong>
            </div>
            <form name="form" class="form-validation">
                <div class="text-danger wrapper text-center" ng-show="authError">

                </div>
                <div class="list-group list-group-sm">
                    <div class="list-group-item">
                        <input name="username" placeholder="用&ensp;户&ensp;名" class="form-control no-border" ng-model="user.name" required>
                    </div>
                    <div class="list-group-item">
                        <input name="email" type="email" placeholder="邮&emsp;&emsp;箱" class="form-control no-border" ng-model="user.email" required>
                    </div>
                    <div class="list-group-item">
                        <input name="password" type="password" placeholder="设置密码" class="form-control no-border" ng-model="user.password" required>
                    </div>
                    <div class="list-group-item">
                        <input name="password" type="password" placeholder="确认密码" class="form-control no-border" ng-model="user.password" required>
                    </div>
                    <div class="list-group-item">
                        <div class="row">
                            <div class="col-xs-7 col-sm-7 col-md-7">
                                <input type="text" placeholder="验&ensp;证&ensp;码" class="form-control no-border" name="captcha" required>
                            </div>
                            <div class="col-xs-5 col-sm-5 col-md-5">
                                <img style="cursor: pointer;" ng-src="{{captchaUrl}}" ng-click="refresh()" />
                            </div>
                        </div>
                    </div>
                </div>
                <div class="checkbox m-b-md m-t-none">
                    <label class="i-checks">
                        <input type="checkbox" ng-model="agree" required><i></i> 我已阅读并同意 <a href>《使用条款》</a>
                    </label>
                </div>
                <button type="submit" class="btn btn-lg btn-primary btn-block" ng-click="register()" ng-disabled='form.$invalid'>注册</button>
                <div class="line line-dashed"></div>
                <div class="row">
                    <div class="col-md-6">
                        <p class="text-right">
                            <small>我已经注册,</small>
                        </p>
                    </div>
                    <div class="col-md-6">
                        <a href="login.html"><span class="text-info-lter">马上登录</span></a>
                    </div>
                </div>
            </form>
        </div>
        <div class="text-center">
            <p>
                <small class="text-muted">开源新媒体管理系统<br>&copy; 2016</small>
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
<script src="${base}/assets/self/scripts/register.js"></script>

</body>
</html>
