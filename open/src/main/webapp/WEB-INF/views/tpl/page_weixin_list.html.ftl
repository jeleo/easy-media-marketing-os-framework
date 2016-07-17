<#import "/spring.ftl" as spring />
<#assign base = "${rc.contextPath}">
<div ng-controller="WeixinListController">
    <div class="bg-light lter b-b wrapper-md hidden-print">
        <a class="btn btn-sm btn-info pull-right" ui-sref="app.weixin.add">添加</a>
        <h1 class="m-n font-thin h3">微信公众号管理</h1>
    </div>
    <div class="wrapper-md">
        <div class="row row-sm">
            <div class="col-lg-3 col-md-4 col-sm-6" ng-repeat="channel in channels">
                <div class="panel b-a">
                    <div class="panel-heading text-center bg-info no-border">
                        <span class="text-u-c m-b-none font-bold">{{channel.name}}</span>
                        <div class="m-b-sm pull-right">
                            <div class="btn-group dropdown">
                                <button class="btn btn-info btn-xs" data-toggle="dropdown">操作 <span class="caret"></span></button>
                                <ul class="dropdown-menu">
                                    <li><a ui-sref="app.weixin.edit({id:channel.id})">编辑</a></li>
                                    <li><a href>删除</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <ul class="list-group">
                        <li class="list-group-item">
                            <i class="icon-check text-success m-r-xs"></i> 公众号类型: {{channel.accountType.name}}
                        </li>
                        <li class="list-group-item">
                            <i class="icon-check text-success m-r-xs"></i> OpenId: {{channel.openId}}
                        </li>
                        <li class="list-group-item">
                            <i class="icon-check text-success m-r-xs"></i> AppId: {{channel.appId}}
                        </li>
                        <li class="list-group-item">
                            <i class="icon-check text-success m-r-xs"></i> 回调地址: ${api_weixin_url}/{{channel.callback}}
                        </li>
                    </ul>
                    <div class="panel-footer text-center">
                        <a href class="btn btn-info font-bold m">进入公众号</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
