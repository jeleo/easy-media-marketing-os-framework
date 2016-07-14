<#import "/spring.ftl" as spring />
<#assign base = "${rc.contextPath}">
<div ng-controller="WeixinSetupController">
    <div class="bg-light lter b-b wrapper-md hidden-print">
        <a class="btn btn-sm btn-info pull-right" ng-click="back()">返回</a>
        <h1 class="m-n font-thin h3">{{setupTypeDisplay}}微信公众号</h1>
    </div>
</div>