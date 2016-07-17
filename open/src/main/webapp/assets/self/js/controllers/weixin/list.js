app.controller('WeixinListController', ['$scope', '$http', '$state', function ($scope, $http, $state) {
    $http.get(api("/weixin/list.json"))
        .success(function (data) {
            $scope.channels = data;
        });
}]);