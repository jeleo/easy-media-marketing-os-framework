<#import "/spring.ftl" as spring />
<#assign base = "${rc.contextPath}">
<#assign resources = "${static_resources_url}">
<!-- navbar header -->
<div class="navbar-header {{app.settings.navbarHeaderColor}}">
    <button class="pull-right visible-xs dk" ui-toggle-class="show" data-target=".navbar-collapse">
        <i class="glyphicon glyphicon-cog"></i>
    </button>
    <button class="pull-right visible-xs" ui-toggle-class="off-screen" data-target=".app-aside" ui-scroll-to="app">
        <i class="glyphicon glyphicon-align-justify"></i>
    </button>
    <!-- brand -->
    <a href="#/" class="navbar-brand text-lt">
        <i class="fa fa-bullhorn text-warning-lter"></i>
        <img src="${resources}/assets/commons/img/Mobile_Marketing.png" alt="." class="hide">
        <span class="hidden-folded m-l-xs text-warning-lter">新媒体营销</span>
    </a>
    <!-- / brand -->
</div>
<!-- / navbar header -->

<!-- navbar collapse -->
<div class="collapse pos-rlt navbar-collapse box-shadow {{app.settings.navbarCollapseColor}}">
    <!-- buttons -->
    <div class="nav navbar-nav hidden-xs">
        <a href class="btn no-shadow navbar-btn" ng-click="app.settings.asideFolded = !app.settings.asideFolded">
            <i class="fa {{app.settings.asideFolded ? 'fa-indent' : 'fa-dedent'}} fa-fw"></i>
        </a>
        <a href class="btn no-shadow navbar-btn" ui-toggle-class="show" target="#aside-user">
            <i class="icon-user fa-fw"></i>
        </a>
    </div>
    <!-- / buttons -->

    <!-- link and dropdown -->
    <!-- / link and dropdown -->

    <!-- search form -->
    <#--<form class="navbar-form navbar-form-sm navbar-left shift" ui-shift="prependTo" target=".navbar-collapse"-->
          <#--role="search" ng-controller="TypeaheadDemoCtrl">-->
        <#--<div class="form-group">-->
            <#--<div class="input-group">-->
                <#--<input type="text" ng-model="selected"-->
                       <#--typeahead="state for state in states | filter:$viewValue | limitTo:8"-->
                       <#--class="form-control input-sm bg-light no-border rounded padder" placeholder="Search projects...">-->
              <#--<span class="input-group-btn">-->
                <#--<button type="submit" class="btn btn-sm bg-light rounded"><i class="fa fa-search"></i></button>-->
              <#--</span>-->
            <#--</div>-->
        <#--</div>-->
    <#--</form>-->
    <!-- / search form -->

    <!-- nabar right -->
    <ul class="nav navbar-nav navbar-right">
        <#--<li class="dropdown hidden-sm" is-open="lang.isopen" dropdown>-->
            <#--<a href class="dropdown-toggle" dropdown-toggle>-->
                <#--{{selectLang}} <b class="caret"></b>-->
            <#--</a>-->
            <#--<!-- dropdown &ndash;&gt;-->
            <#--<ul class="dropdown-menu animated fadeInRight w">-->
                <#--<li ng-repeat="(langKey, label) in langs">-->
                    <#--<a ng-click="setLang(langKey, $event)" href>{{label}}</a>-->
                <#--</li>-->
            <#--</ul>-->
            <#--<!-- / dropdown &ndash;&gt;-->
        <#--</li>-->
        <li class="hidden-xs">
            <a ui-fullscreen></a>
        </li>
        <li class="dropdown" dropdown>
            <a href class="dropdown-toggle" dropdown-toggle>
                <i class="icon-bell fa-fw"></i>
                <span class="visible-xs-inline">我的消息</span>
                <span class="badge badge-sm up bg-danger pull-right-xs">1</span>
            </a>
            <!-- dropdown -->
            <div class="dropdown-menu w-xl animated fadeInUp">
                <div class="panel bg-white">
                    <div class="panel-heading b-light bg-light">
                        <strong>您有 <span>1</span> 条新的消息</strong>
                    </div>
                    <div class="list-group">
                        <a href class="list-group-item">
                            <span class="clear block m-b-none">
                                1.0 initial released<br>
                                <small class="text-muted">1 hour ago</small>
                            </span>
                        </a>
                    </div>
                    <div class="panel-footer text-sm">
                        <a href class="pull-right"><i class="fa fa-cog"></i></a>
                        <a href="#notes" data-toggle="class:show animated fadeInRight">查看所有消息</a>
                    </div>
                </div>
            </div>
            <!-- / dropdown -->
        </li>
        <li class="dropdown" dropdown>
            <a href class="dropdown-toggle clear" dropdown-toggle>
              <span class="thumb-sm avatar pull-right m-t-n-sm m-b-n-sm m-l-sm">
                <img src="${resources}/assets/commons/img/avatar_loss.png" alt="...">
                <i class="on md b-white bottom"></i>
              </span>
                <span class="hidden-sm hidden-md"><#if username??>${username}<#else>anonymous</#if></span> <b class="caret"></b>
            </a>
            <!-- dropdown -->
            <ul class="dropdown-menu animated fadeInRight w">
                <li>
                    <a ui-sref="app.page.profile">我的资料</a>
                </li>
                <li class="divider"></li>
                <li>
                    <a ng-click="logout()">退出</a>
                </li>
            </ul>
            <!-- / dropdown -->
        </li>
    </ul>
    <!-- / navbar right -->

</div>
<!-- / navbar collapse -->
