angular.module('app', []).controller('signupFormController', function($scope) {
    $scope.refresh = function() {
       $scope.captchaUrl = $scope.captchaUrl + "&" + Math.floor(Math.random() * 100);
    };
    $scope.register = function() {
        form.submit();
    };
});