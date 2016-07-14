<#import "/spring.ftl" as spring />
<#assign base = "${rc.contextPath}">
<div ng-controller="WeixinSetupController" ng-init="isAdd=${isAdd}">
    <div class="bg-light lter b-b wrapper-md hidden-print">
        <a href class="btn btn-sm btn-info pull-right" >返回</a>
        <h1 class="m-n font-thin h3">{{setupType}}微信公众号</h1>
    </div>
</div>