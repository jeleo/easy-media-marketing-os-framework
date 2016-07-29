// navbar controller
app.controller('NavController', ['$scope', '$http', '$state', function ($scope, $http, $state) {
    $scope.logout = function () {
        $http.get(api("/auth/logout"))
            .then(function (response) {
                $state.go('access.signin');
            }, function (x) {
            });
    };
}]);