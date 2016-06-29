angular.module('login', []).controller('signinFormController', function($scope) {
    $scope.refresh = function() {
       $scope.captchaUrl = $scope.captchaUrl + "?" + Math.floor(Math.random() * 100);
    };
    $scope.login = function() {
        form.submit();
    };
});