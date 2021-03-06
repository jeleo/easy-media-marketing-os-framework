<#import "/spring.ftl" as spring />
<#assign base = "${rc.contextPath}">
<#assign resources = "${static_resources_url}">
<div class="aside-wrap">
    <!-- if you want to use a custom scroll when aside fixed, use the slimScroll
      <div class="navi-wrap" ui-jq="slimScroll" ui-options="{height:'100%', size:'8px'}">
    -->
    <div class="navi-wrap">
        <!-- user -->
        <div class="clearfix hidden-xs text-center hide" id="aside-user">
            <div class="dropdown wrapper" dropdown>
                <a ui-sref="app.page.profile">
                    <span class="thumb-lg w-auto-folded avatar m-t-sm">
                        <img src="${resources}/assets/commons/img/avatar_loss.png" class="img-full" alt="...">
                    </span>
                </a>
                <a href class="dropdown-toggle hidden-folded" dropdown-toggle>
                    <span class="clear">
                        <span class="block m-t-sm">
                            <strong class="font-bold text-lt"><#if username??>${username}<#else>anonymous</#if></strong>
                            <b class="caret"></b>
                        </span>
                        <span class="text-muted text-xs block">管理员</span>
                    </span>
                </a>
                <!-- dropdown -->
                <ul class="dropdown-menu animated fadeInRight w hidden-folded">
                    <li>
                        <a ui-sref="app.page.profile">我的资料</a>
                    </li>
                    <li class="divider"></li>
                    <li>
                        <a ng-click="logout()">退出</a>
                    </li>
                </ul>
                <!-- / dropdown -->
            </div>
            <div class="line dk hidden-folded"></div>
        </div>
        <!-- / user -->

        <!-- nav -->
        <nav ui-nav class="navi clearfix" ng-include="appMenuUrl"></nav>
        <!-- nav -->

        <!-- aside footer -->
        <#--<div class="wrapper m-t">-->
            <#--<div class="text-center-folded">-->
                <#--<span class="pull-right pull-none-folded">60%</span>-->
                <#--<span class="hidden-folded" translate="aside.MILESTONE">Milestone</span>-->
            <#--</div>-->
            <#--<progressbar value="60" class="progress-xxs m-t-sm dk" type="info"></progressbar>-->
            <#--<div class="text-center-folded">-->
                <#--<span class="pull-right pull-none-folded">35%</span>-->
                <#--<span class="hidden-folded" translate="aside.RELEASE">Release</span>-->
            <#--</div>-->
            <#--<progressbar value="35" class="progress-xxs m-t-sm dk" type="primary"></progressbar>-->
        <#--</div>-->
        <!-- / aside footer -->
    </div>
</div>