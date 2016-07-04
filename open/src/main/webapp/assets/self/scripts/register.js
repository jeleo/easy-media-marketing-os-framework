angular.module('app', ["ui.bootstrap"]).controller('signupFormController', function($scope, $modal, $http) {
    $scope.refresh = function() {
       $scope.captchaUrl = $scope.captchaUrl + "&" + Math.floor(Math.random() * 100);
    };
    $scope.register = function() {
        $http({
            method  : 'POST',
            url     : $scope.registerUrl,
            data    : $scope.user
        }).success(function(data) {
            console.log(data);
        })
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
});