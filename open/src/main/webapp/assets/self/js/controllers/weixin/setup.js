app.controller('WeixinSetupController', ['$scope', '$http', '$state', function ($scope, $http, $state) {
    if ($scope.isAdd == true) {
        $scope.setupType = "添加";
    } else {
        $scope.setupType = "修改";
    }
}]);