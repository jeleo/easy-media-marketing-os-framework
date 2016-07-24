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
            <span class="font-bold">公众号详情</span>
        </a>
    </li>
    <li ui-sref-active="active">
        <a ui-sref="app.weixin.list">
            <i class="fa fa-weixin text-info-lter"></i>
            <span>自定义菜单</span>
        </a>
    </li>
    <li ui-sref-active="active">
        <a ui-sref="app.weixin.list">
            <i class="fa fa-weixin text-info-lter"></i>
            <span>关键词回复</span>
        </a>
    </li>
    <li ui-sref-active="active">
        <a ui-sref="app.weixin.list">
            <i class="fa fa-weixin text-info-lter"></i>
            <span>素材库</span>
        </a>
    </li>
</ul>
<!-- / list -->
