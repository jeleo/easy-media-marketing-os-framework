<#import "/spring.ftl" as spring />
<#assign base = "${rc.contextPath}">
<#assign resources = "${static_resources_url}">
<!DOCTYPE html>
<html lang="en" data-ng-app="app">
<head>
    <meta charset="utf-8"/>
    <title>Easy Media Marketing OS</title>
    <meta name="description" content="new media, marketing, weixin, weibo"/>
    <meta name="keywords" content="new media, marketing, weixin, weibo"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1"/>
    <link rel="stylesheet" href="${resources}/assets/vendor/present/animate.css/animate.css" type="text/css"/>
    <link rel="stylesheet" href="${resources}/assets/vendor/present/font-awesome/css/font-awesome.min.css" type="text/css"/>
    <link rel="stylesheet" href="${resources}/assets/vendor/present/simple-line-icons/css/simple-line-icons.css" type="text/css"/>
    <link rel="stylesheet" href="${resources}/assets/vendor/jquery/bootstrap/dist/css/bootstrap.css" type="text/css"/>

    <!-- build:css css/app.min.css -->
    <link rel="stylesheet" href="${resources}/assets/admin/css/font.css" type="text/css"/>
    <link rel="stylesheet" href="${resources}/assets/admin/css/app.css" type="text/css"/>
    <!-- endbuild -->

    <link rel="shortcut icon" href="${resources}/assets/commons/img/favicon.ico"/>
</head>
<body ng-controller="AppCtrl">
<div style="display: none;" id="context_path">${base}</div>
<div style="display: none;" id="static_resources_url">${resources}</div>
<div class="app" id="app"
     ng-class="{'app-header-fixed':app.settings.headerFixed, 'app-aside-fixed':app.settings.asideFixed, 'app-aside-folded':app.settings.asideFolded, 'app-aside-dock':app.settings.asideDock, 'container':app.settings.container}"
     ui-view></div>

<!-- build:js js/app.angular.js -->
<!-- jQuery -->
<script src="${resources}/assets/vendor/jquery/jquery/dist/jquery.js"></script>
<!-- Bootstrap -->
<script src="${resources}/assets/vendor/jquery/bootstrap/dist/js/bootstrap.js"></script>

<!-- Angular -->
<script src="${resources}/assets/vendor/angular/angular/angular.js"></script>

<script src="${resources}/assets/vendor/angular/angular-animate/angular-animate.js"></script>
<script src="${resources}/assets/vendor/angular/angular-aria/angular-aria.js"></script>
<script src="${resources}/assets/vendor/angular/angular-cookies/angular-cookies.js"></script>
<script src="${resources}/assets/vendor/angular/angular-messages/angular-messages.js"></script>
<script src="${resources}/assets/vendor/angular/angular-resource/angular-resource.js"></script>
<script src="${resources}/assets/vendor/angular/angular-sanitize/angular-sanitize.js"></script>
<script src="${resources}/assets/vendor/angular/angular-touch/angular-touch.js"></script>

<script src="${resources}/assets/vendor/angular/angular-ui-router/release/angular-ui-router.js"></script>
<script src="${resources}/assets/vendor/angular/ngstorage/ngStorage.js"></script>
<script src="${resources}/assets/vendor/angular/angular-ui-utils/ui-utils.js"></script>

<!-- bootstrap -->
<script src="${resources}/assets/vendor/angular/angular-bootstrap/ui-bootstrap-tpls.js"></script>
<!-- lazyload -->
<script src="${resources}/assets/vendor/angular/oclazyload/dist/ocLazyLoad.js"></script>
<!-- translate -->
<script src="${resources}/assets/vendor/angular/angular-translate/angular-translate.js"></script>
<script src="${resources}/assets/vendor/angular/angular-translate-loader-static-files/angular-translate-loader-static-files.js"></script>
<script src="${resources}/assets/vendor/angular/angular-translate-storage-cookie/angular-translate-storage-cookie.js"></script>
<script src="${resources}/assets/vendor/angular/angular-translate-storage-local/angular-translate-storage-local.js"></script>

<!-- App -->
<script src="${resources}/assets/admin/js/app.js"></script>
<script src="${resources}/assets/admin/js/config.js"></script>
<script src="${resources}/assets/admin/js/config.lazyload.js"></script>
<script src="${resources}/assets/admin/js/factories/globalService.js"></script>
<script src="${resources}/assets/admin/js/config.router.js"></script>
<script src="${resources}/assets/admin/js/main.js"></script>
<script src="${resources}/assets/admin/js/services/ui-load.js"></script>
<script src="${resources}/assets/admin/js/filters/fromNow.js"></script>
<script src="${resources}/assets/admin/js/directives/setnganimate.js"></script>
<script src="${resources}/assets/admin/js/directives/ui-butterbar.js"></script>
<script src="${resources}/assets/admin/js/directives/ui-focus.js"></script>
<script src="${resources}/assets/admin/js/directives/ui-fullscreen.js"></script>
<script src="${resources}/assets/admin/js/directives/ui-jq.js"></script>
<script src="${resources}/assets/admin/js/directives/ui-module.js"></script>
<script src="${resources}/assets/admin/js/directives/ui-nav.js"></script>
<script src="${resources}/assets/admin/js/directives/ui-scroll.js"></script>
<script src="${resources}/assets/admin/js/directives/ui-shift.js"></script>
<script src="${resources}/assets/admin/js/directives/ui-toggleclass.js"></script>
<script src="${resources}/assets/admin/js/controllers/bootstrap.js"></script>
<!-- endbuild -->
<!-- Lazy loading -->
</body>
</html>
