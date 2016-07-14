<#import "/spring.ftl" as spring />
<#assign base = "${rc.contextPath}">
<div ng-controller="WeixinSetupController">
    <div class="bg-light lter b-b wrapper-md hidden-print">
        <a class="btn btn-sm btn-info pull-right" ng-click="back()">返回</a>
        <h1 class="m-n font-thin h3">{{setupTypeDisplay}}微信公众号</h1>
    </div>
    <div class="wrapper-md">
        <div class="col-sm-6">
            <form class="bs-example form-horizontal">
                <div class="form-group">
                    <label class="col-lg-4 control-label">
                        公众号名称
                        <span class="text-danger-lter">*</span>
                    </label>
                    <div class="col-lg-8">
                        <input type="text" class="form-control" placeholder="">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-lg-4 control-label">
                        公众号OpenId
                        <span class="text-danger-lter">*</span>
                    </label>
                    <div class="col-lg-8">
                        <input type="text" class="form-control" placeholder="">
                        <span class="help-block m-b-none">请认真填写,错了不能修改!</span>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-lg-4 control-label">
                        公众号AppID
                        <span class="text-danger-lter">*</span>
                    </label>
                    <div class="col-lg-8">
                        <input type="text" class="form-control" placeholder="">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-lg-4 control-label">
                        公众号AppSecret
                        <span class="text-danger-lter">*</span>
                    </label>
                    <div class="col-lg-8">
                        <input type="text" class="form-control" placeholder="">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-lg-4 control-label">
                        微信号
                        <span class="text-danger-lter">*</span>
                    </label>
                    <div class="col-lg-8">
                        <input type="text" class="form-control" placeholder="">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-lg-4 control-label">公众号类型</label>
                    <div class="col-lg-8">
                        <div class="input-group">
                            <ui-select ng-model="type.selected" theme="bootstrap">
                                <ui-select-match placeholder="选择公众号类型">{{$select.selected.name}}</ui-select-match>
                                <ui-select-choices repeat="item in types | filter: $select.search">
                                    <span ng-bind-html="item.name | highlight: $select.search"></span>
                                    <small ng-bind-html="item.value | highlight: $select.search"></small>
                                </ui-select-choices>
                            </ui-select>
                            <span class="input-group-btn">
                                <button ng-click="type.selected = undefined" class="btn btn-default">
                                    <span class="glyphicon glyphicon-trash"></span>
                                </button>
                            </span>

                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-lg-4 control-label">
                        备注
                    </label>
                    <div class="col-lg-8">
                        <input type="text" class="form-control" placeholder="">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-lg-offset-4 col-lg-8">
                        <button type="submit" class="btn btn-sm btn-info">保存</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>