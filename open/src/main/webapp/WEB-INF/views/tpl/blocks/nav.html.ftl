<#import "/spring.ftl" as spring />
<#assign base = "${rc.contextPath}">
<!-- list -->
<ul class="nav">
    <li class="hidden-folded padder m-t m-b-sm text-muted text-xs">
        <span translate="aside.nav.HEADER">向导</span>
    </li>
    <li ui-sref-active="active">
        <a ui-sref="app.dashboard">
            <i class="glyphicon glyphicon-leaf icon text-info-lter"></i>
            <span class="font-bold">控制台</span>
        </a>
    </li>
    <li class="line dk"></li>
    <li class="hidden-folded padder m-t m-b-sm text-muted text-xs">
        <span>我的渠道</span>
    </li>
    <li ui-sref-active="active">
        <a ui-sref="app.weixin.list">
            <i class="fa fa-weixin text-success-lter"></i>
            <span>微信公众号</span>
        </a>
    </li>
    <li class="line dk hidden-folded"></li>

    <li class="hidden-folded padder m-t m-b-sm text-muted text-xs">
        <span>账号日志</span>
    </li>
    <li ui-sref-active="active">
        <a href="#">
            <i class="fa fa-user text-primary-lter"></i>
            <span>账户管理</span>
        </a>
    </li>
    <li ui-sref-active="active">
        <a href="#">
            <i class="fa fa-puzzle-piece text-primary-lter"></i>
            <span>角色管理</span>
        </a>
    </li>
    <li ui-sref-active="active">
        <a href="#">
            <i class="fa fa-history text-primary-lter"></i>
            <span>查看日志</span>
        </a>
    </li>
</ul>
<!-- / list -->
