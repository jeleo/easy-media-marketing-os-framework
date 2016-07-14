<#import "/spring.ftl" as spring />
<#assign base = "${rc.contextPath}">
<!-- navbar -->
<div ng-controller="NavController" data-ng-include=" 'views/header.html' " class="app-header navbar">
</div>
<!-- / navbar -->

<!-- menu -->
<div ng-controller="MenuController" data-ng-include=" 'views/aside.html' " class="app-aside hidden-xs {{app.settings.asideColor}}">
</div>
<!-- / menu -->

<!-- content -->
<div class="app-content">
    <div ui-butterbar></div>
    <a href class="off-screen-toggle hide" ui-toggle-class="off-screen" data-target=".app-aside"></a>

    <div class="app-content-body fade-in-up" ui-view></div>
</div>
<!-- /content -->

<!-- footer -->
<div class="app-footer wrapper b-t bg-light">
    <span class="pull-right">
        {{app.version}}
        <a href ui-scroll-to="app" class="m-l-sm text-muted">
            <i class="fa fa-long-arrow-up"></i>
        </a>
    </span>
    ${copyright}
</div>
<!-- / footer -->

<div data-ng-include=" 'tpl/blocks/settings.html' " class="settings panel panel-default">
</div>
