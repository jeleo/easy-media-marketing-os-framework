'use strict';

/* Controllers */
// signin controller
app.controller('SigninFormController', ['$scope', '$http', '$state', '$stateParams', function ($scope, $http, $state, $stateParams) {
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
                if (response.data.errcode == 0) {
                    var from = $stateParams.from;
                    $state.go(from && from != null && from != 'access.signin' ? from : 'app.dashboard');
                } else {
                    $scope.authError = response.data.errmsg;
                }
            }, function (x) {
                $scope.authError = 'Server Error';
            });
    };
}]);