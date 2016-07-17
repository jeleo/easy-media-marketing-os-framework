app.controller('WeixinSetupController', ['$scope', '$http', '$state', '$location', function ($scope, $http, $state, $location) {
    var setupTypeIsAdd = new RegExp("add" + "$").test($location.url());
    if (setupTypeIsAdd) {
        $scope.setupTypeDisplay = "添加";
    } else {
        $scope.setupTypeDisplay = "修改";
    }
    $scope.back = function () {
        $state.go("app.weixin.list");
    };
    $http.get(api("/constants/weixin/accountType.json"))
        .success(function (data) {
            $scope.accountTypes = data;
        });
    $scope.accountType = "";
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
}]);