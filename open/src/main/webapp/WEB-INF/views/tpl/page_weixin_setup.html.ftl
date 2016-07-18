<#import "/spring.ftl" as spring />
<#assign base = "${rc.contextPath}">
<div ng-controller="WeixinSetupController">
    <div class="bg-light lter b-b wrapper-md hidden-print">
        <a class="btn btn-sm btn-info pull-right" ng-click="back()">返回</a>
        <h1 class="m-n font-thin h3">{{setupTypeDisplay}}微信公众号</h1>
    </div>
    <div class="wrapper-md">
        <div class="col-sm-6">
            <form class="bs-example form-horizontal form-validation">
                <div class="form-group">
                    <div class="text-danger wrapper text-center" ng-show="authError">
                        {{authError}}
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-lg-4 control-label">
                        公众号名称
                        <span class="text-danger-lter">*</span>
                    </label>
                    <div class="col-lg-8">
                        <input type="text" class="form-control" placeholder="" name="name" ng-model="setup.name" required>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-lg-4 control-label">
                        公众号类型
                        <span class="text-danger-lter">*</span>
                    </label>
                    <div class="col-lg-8">
                        <ui-select name="accountType" ng-model="setup.accountType" ng-if="setupTypeIsAdd" required theme="bootstrap">
                            <ui-select-match placeholder="-- 请选择 --">{{$select.selected.name}}</ui-select-match>
                            <ui-select-choices repeat="item in accountTypes | filter: $select.search">
                                <div ng-bind-html="item.name | highlight: $select.search"></div>
                            </ui-select-choices>
                        </ui-select>
                        <span class="help-block m-b-none" ng-if="setupTypeIsAdd">请认真选择,错了不能修改!</span>
                        <p class="form-control-static" ng-if="!setupTypeIsAdd">{{setup.accountType.name}}</p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-lg-4 control-label">
                        公众号OpenId
                        <span class="text-danger-lter">*</span>
                    </label>
                    <div class="col-lg-8">
                        <input type="text" class="form-control" placeholder="" name="openId" ng-model="setup.openId" ng-if="setupTypeIsAdd" required>
                        <span class="help-block m-b-none" ng-if="setupTypeIsAdd">请认真填写,错了不能修改!</span>
                        <p class="form-control-static" ng-if="!setupTypeIsAdd">{{setup.openId}}</p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-lg-4 control-label">
                        公众号AppID
                        <span class="text-danger-lter">*</span>
                    </label>
                    <div class="col-lg-8">
                        <input type="text" class="form-control" placeholder="" name="appId" ng-model="setup.appId" required>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-lg-4 control-label">
                        公众号AppSecret
                        <span class="text-danger-lter">*</span>
                    </label>
                    <div class="col-lg-8">
                        <input type="text" class="form-control" placeholder="" name="appSecret" ng-model="setup.appSecret" required>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-lg-4 control-label">
                        微信号
                        <span class="text-danger-lter">*</span>
                    </label>
                    <div class="col-lg-8">
                        <input type="text" class="form-control" placeholder="" name="weixinAccount" ng-model="setup.weixinAccount" required>
                    </div>
                </div>
                <div class="form-group" ng-if="!setupTypeIsAdd">
                    <label class="col-lg-4 control-label">
                        回调地址
                    </label>
                    <div class="col-lg-8">
                        <p class="form-control-static">${api_weixin_url}/{{setup.callback}}</p>
                    </div>
                </div>
                <div class="form-group" ng-if="!setupTypeIsAdd">
                    <label class="col-lg-4 control-label">
                        Token
                    </label>
                    <div class="col-lg-8">
                        <p class="form-control-static">{{setup.token}}</p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-lg-4 control-label">
                        备注
                    </label>
                    <div class="col-lg-8">
                        <input type="text" class="form-control" placeholder="" name="comment" ng-model="setup.comment" required>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-lg-offset-4 col-lg-8">
                        <button type="submit" class="btn btn-sm btn-info" ng-click="saveSetup()" ng-disabled='form.$invalid'>保存</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>