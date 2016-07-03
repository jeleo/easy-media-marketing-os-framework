angular.module('app', ["ui.bootstrap"]).controller('signupFormController', function($scope, $modal) {
    $scope.refresh = function() {
       $scope.captchaUrl = $scope.captchaUrl + "&" + Math.floor(Math.random() * 100);
    };
    $scope.register = function() {
        form.submit();
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