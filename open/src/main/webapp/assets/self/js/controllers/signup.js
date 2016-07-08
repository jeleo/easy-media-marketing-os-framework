'use strict';

// signup controller
app.controller('SignupFormController', ['$scope', '$http', '$state', function ($scope, $http, $state) {
    $scope.user = {};
    $scope.authError = null;
    $scope.refresh = function () {
        $scope.captchaUrl = $scope.captchaUrl + "&" + Math.floor(Math.random() * 100);
    };
    $scope.signup = function () {
        $scope.authError = null;
        // Try to create
        $http.post('api/signup', {name: $scope.user.name, email: $scope.user.email, password: $scope.user.password})
            .then(function (response) {
                if (!response.data.user) {
                    $scope.authError = response;
                } else {
                    $state.go('app.dashboard-v1');
                }
            }, function (x) {
                $scope.authError = 'Server Error';
            });
    };
}]);