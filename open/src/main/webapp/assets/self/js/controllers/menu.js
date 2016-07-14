// navbar controller
app.controller('MenuController', ['$scope', '$http', '$state', function ($scope, $http, $state) {
    $scope.logout = function () {
        $http.get(api("/auth/logout"))
            .then(function (response) {
                $state.go('access.signin');
            }, function (x) {
            });
    };
}]);