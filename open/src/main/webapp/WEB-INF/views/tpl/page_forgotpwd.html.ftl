<#import "/spring.ftl" as spring />
<#assign base = "${rc.contextPath}">
<div class="container w-xl w-auto-xs" ng-init="app.settings.container = false;">
    <div class="navbar-brand block m-t">{{app.name}}</div>

    <div class="m-b-lg">
        <div class="wrapper text-center">
            <i class="icon icon-eyeglasses"></i>
            <strong>找回密码</strong>
        </div>
        <form name="reset" ng-init="isCollapsed=true">
            <div class="list-group list-group-sm">
                <div class="list-group-item">
                    <input type="email" placeholder="请输入注册邮箱" ng-model="email" ng-disabled="true" class="form-control no-border" required>
                </div>
            </div>
            <button type="submit" ng-disabled="reset.$invalid" class="btn btn-lg btn-primary btn-block" ng-click="isCollapsed = !isCollapsed">
                敬请期待
            </button>
        </form>
        <div collapse="isCollapsed" class="m-t">
            <div class="alert alert-success">
                <p>
                    密码重置链接已发送至您的邮箱，有效期24小时，请及时检查。
                    <a ui-sref="access.signin" class="btn btn-sm btn-success">登录</a>
                </p>
            </div>
        </div>
    </div>
    <div class="text-center" ng-include="'views/page_footer.html'">
        {% include 'blocks/page_footer.html' %}
    </div>
</div>