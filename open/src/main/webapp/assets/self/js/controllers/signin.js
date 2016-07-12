'use strict';

/* Controllers */
// signin controller
app.controller('SigninFormController', ['$scope', '$http', '$state', function ($scope, $http, $state) {
    $scope.user = {};
    $scope.authError = null;
    $scope.refresh = function () {
        $scope.captchaUrl = $scope.captchaUrl + "?" + Math.floor(Math.random() * 100);
    };
    $scope.login = function () {
        $scope.authError = null;
        // Try to login
        $http.post(
            api("/auth/login"),
            $scope.user,
            {
                headers : {
                    'AuthType': 'ajax'
                }
            })
            .then(function (response) {
                if (!response.data.user) {
                    $scope.authError = 'Email or Password not right';
                } else {
                    $state.go('app.dashboard');
                }
            }, function (x) {
                $scope.authError = 'Server Error';
            });
    };
}]);