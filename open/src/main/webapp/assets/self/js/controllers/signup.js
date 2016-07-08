'use strict';

// signup controller
app.controller('SignupFormController', ['$scope', '$http', '$state', '$modal', function ($scope, $http, $state, $modal) {
    //$scope.user = {};
    $scope.authError = null;
    $scope.refresh = function () {
        $scope.captchaUrl = $scope.captchaUrl + "&" + Math.floor(Math.random() * 100);
    };
    $scope.showTerms = function()
    {
        $modal.open({
            templateUrl: 'terms.html',
            controller: function ($scope, $modalInstance) {
                $scope.agree = function () {
                    $modalInstance.close();
                };
                $scope.disagree = function () {
                    $modalInstance.dismiss('cancel');
                };
            }
        });
    };
    $scope.register = function () {
        var registerUser = $scope.user;
        $scope.authError = null;
        // Try to create
        $http.post(api("/auth/register.html"), registerUser)
            .then(function (response) {
                if (response.data.errcode == 0) {
                    $modal.open({
                        templateUrl: 'registerSuccess.html',
                        controller: function ($scope, $modalInstance) {
                            $scope.registered = registerUser.username;
                            $scope.login = function () {
                                $modalInstance.close();
                                $state.go('access.signin');
                            };
                        }
                    });
                } else {
                    $scope.authError = response.data.errmsg;
                }
            }, function (x) {
                $scope.authError = 'Server Error';
                console.log(x);
            });
    };
}]);