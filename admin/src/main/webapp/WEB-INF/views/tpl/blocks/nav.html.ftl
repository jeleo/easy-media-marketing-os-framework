<#import "/spring.ftl" as spring />
<#assign base = "${rc.contextPath}">
<!-- list -->
<ul class="nav">
    <li class="hidden-folded padder m-t m-b-sm text-muted text-xs">
        <span translate="aside.nav.HEADER">向导</span>
    </li>
    <li ui-sref-active="active">
        <a ui-sref="app.dashboard">
            <i class="glyphicon glyphicon-leaf icon text-primary-lter"></i>
            <span class="font-bold">控制台</span>
        </a>
    </li>

    <li class="line dk hidden-folded"></li>

    <li class="hidden-folded padder m-t m-b-sm text-muted text-xs">
        <span>系统管理</span>
    </li>
    <li ui-sref-active="active">
        <a href="#">
            <i class="fa fa-user text-primary-lter"></i>
            <span>管理员列表</span>
        </a>
    </li>
    <li ui-sref-active="active">
        <a href="#">
            <i class="fa fa-history text-primary-lter"></i>
            <span>查看日志</span>
        </a>
    </li>

    <li class="line dk hidden-folded"></li>

    <li class="hidden-folded padder m-t m-b-sm text-muted text-xs">
        <span>公众平台管理</span>
    </li>
    <li ui-sref-active="active">
        <a href="#">
            <i class="fa fa-users text-primary-lter"></i>
            <span>公众用户</span>
        </a>
    </li>
</ul>
<!-- / list -->
