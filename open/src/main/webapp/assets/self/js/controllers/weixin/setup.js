app.controller('WeixinSetupController', ['$scope', '$http', '$state', '$location', function ($scope, $http, $state, $location) {
    $scope.back = function () {
        $state.go("app.weixin.list");
    };
    var setupTypeIsAdd = new RegExp("add" + "$").test($location.url());
    if (setupTypeIsAdd) {
        $scope.setupTypeDisplay = "添加";
        // 优先获取微信公众号枚举类型
        $http.get(api("/constants/weixin/accountType.json"))
            .success(function (data) {
                $scope.accountTypes = data;
                $scope.saveSetup = function () {
                    $http.post(api("/weixin/add.json"), $scope.setup)
                        .success(function (data) {
                            if (data.errcode == 0) {
                                $scope.back();
                            } else {
                                $scope.authError = data.errmsg;
                            }
                        });
                }
            });
        $scope.accountType = "";
    } else {
        $scope.setupTypeDisplay = "修改";
        var id = $location.search()['id'];
        $http.get(api("/weixin/get.json?id=" + id))
            .success(function (data) {
                $scope.setup = data;
                $scope.saveSetup = function () {
                    $http.post(api("/weixin/edit.json"), $scope.setup)
                        .success(function (data) {
                            if (data.errcode == 0) {
                                $scope.back();
                            } else {
                                $scope.authError = data.errmsg;
                            }
                        });
                }
            });
    }


}]);