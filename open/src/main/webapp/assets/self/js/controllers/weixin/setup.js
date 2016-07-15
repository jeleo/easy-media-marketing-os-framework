app.controller('WeixinSetupController', ['$scope', '$http', '$state', '$location', function ($scope, $http, $state, $location) {
    var setupTypeIsAdd = new RegExp("add"+"$").test($location.url());
    if (setupTypeIsAdd) {
        $scope.setupTypeDisplay = "添加";
    } else {
        $scope.setupTypeDisplay = "修改";
    }
    $scope.back = function() {
        $state.go("app.weixin.list");
    };
    $scope.types = [
        {name : "服务号", value : "fuwu"},
        {name : "订阅号", value : "dingyue"}
    ];
    $scope.type = "";
}]);